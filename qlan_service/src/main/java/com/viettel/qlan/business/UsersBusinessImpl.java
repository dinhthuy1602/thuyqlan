package com.viettel.qlan.business;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.security.Key;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.base.common.BusinessException;
import com.viettel.qlan.bo.ActionAudit;
import com.viettel.qlan.bo.AuditDetail;
import com.viettel.qlan.bo.Users;
import com.viettel.qlan.constant.Constants;
import com.viettel.qlan.dao.ActionAuditDAO;
import com.viettel.qlan.dao.AuditDetailDAO;
import com.viettel.qlan.dao.ObjectsDAO;
import com.viettel.qlan.dao.RoleUserDAO;
import com.viettel.qlan.dao.RolesDAO;
import com.viettel.qlan.dao.UsersDAO;
import com.viettel.qlan.dto.LoginDTO;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.qlan.dto.ResultDTO;
import com.viettel.qlan.dto.RoleObjectDTO;
import com.viettel.qlan.dto.RoleUserDTO;
import com.viettel.qlan.dto.RolesDTO;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.utils.DataUtils;
import com.viettel.qlan.utils.DateUtil;
import com.viettel.qlan.utils.PasswordUtil;
import com.viettel.qlan.utils.QlanResource;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import com.viettel.service.base.dto.DataListDTO;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("usersBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsersBusinessImpl extends BaseFWBusinessImpl<UsersDAO, UsersDTO, Users> implements UsersBusiness {
	
	private static final Logger log = Logger.getLogger(UsersBusinessImpl.class);
	private static String INVALID_ACC_KEY="invalid.account";
	private static String DISPLAY_NAME_KEY="user.management.display.name";
	private static String TABLE_NAME="USERS";
	private static String ACCOUNT_VI_KEY="account_vi";
	private static String INVALID_VI_KEY="invalid_vi";
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private RolesDAO rolesDAO;
	
	@Autowired
	private RoleUserDAO roleUserDAO;

	@Autowired
	private ActionAuditDAO actionAuditDAO;

	@Autowired
	private AuditDetailDAO auditDetailDAO;
	
	@Autowired
	ActionAuditBusinessImpl actionAuditBusinessImpl;
	@Autowired
	private ObjectsDAO objectsDAO;

	public UsersBusinessImpl() {
		tModel = new Users();
		tDAO = usersDAO;
	}

	@Override
	public UsersDAO gettDAO() {
		return usersDAO;
	}

	@Override
	public UsersDTO getUsersInfo(String userName) {
		UsersDTO usersDTO = usersDAO.getUsersInfo(userName);
		List<ObjectsDTO> listObjParent=objectsDAO.getListObjects(usersDTO.getUserId(), null);
		
		for(ObjectsDTO objParent:listObjParent){
			List<ObjectsDTO> listObjChild=objectsDAO.getListObjects(usersDTO.getUserId(), objParent.getObjectId());
			objParent.setListChildObject(listObjChild);
		}
		
		usersDTO.setListObject(listObjParent);
		return usersDTO;
	}

	@Override
	@Transactional
	public ResultDTO login(String userName, String password, HttpServletRequest request) throws Exception {
		HttpSession httpSession=request.getSession();
		ResultDTO resultDTO = new ResultDTO();
		// check null username or password
		if (!StringUtils.isNotEmpty(userName) || !StringUtils.isNotEmpty(password)) {
			resultDTO.setMessage(QlanResource.get("username.password.is.empty"));
			resultDTO.setError(true);
			resultDTO.setErrorCode(404002);
			return resultDTO;
		}
		String hasdPass = PasswordUtil.hashPassword(password, null);
		UsersDTO usersDTO = usersDAO.getUsersInfo(userName);
		// check username invalid db
		if (usersDTO == null) {
			resultDTO.setMessage(QlanResource.get(INVALID_ACC_KEY));
			resultDTO.setError(true);
			resultDTO.setErrorCode(404001);
			return resultDTO;
		}

		// check username lock
		if (usersDTO.getLastLockDate()!=null && usersDTO.getLastLockDate().before(new Date()) && 0l == usersDTO.getStatus()) {
			resultDTO.setMessage(QlanResource.get("account.is.lock"));
			resultDTO.setError(true);
			resultDTO.setErrorCode(400001);
			return resultDTO;
		}
		// check IP
		int checkIp=checkIp(request, getClientIpAddr(request), usersDTO.getIp(), usersDTO.getCheckIp());
//		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		log.info("IP address: "+ getClientIpAddr(request));
		if(checkIp==2){
			resultDTO.setMessage(QlanResource.get("ipCharacter.message"));
			resultDTO.setError(true);
			resultDTO.setErrorCode(400002);
			return resultDTO;
		} else if (checkIp==3){
			resultDTO.setMessage(QlanResource.get("ip.message"));
			resultDTO.setError(true);
			resultDTO.setErrorCode(400003);
			return resultDTO;
		} else if (checkIp==1){
			resultDTO.setMessage(QlanResource.get("ipinvalid.message"));
			resultDTO.setError(true);
			resultDTO.setErrorCode(400003);
			return resultDTO;
		}
		// check password
		if (!hasdPass.equals(usersDTO.getPassword())) {
			// check login fail count >=5 => lock account
			if (usersDTO.getLoginFailureCount() == null || usersDTO.getLoginFailureCount() < 4) {
				usersDAO.updateLoginFailCount(userName);
				resultDTO.setError(true);
				resultDTO.setMessage(QlanResource.get(INVALID_ACC_KEY));
				resultDTO.setErrorCode(404001);
				return resultDTO;
			} else {
				usersDAO.updateLoginFailCount(userName);
				usersDAO.lockAccount(userName);
				ActionAudit actionAudit = new ActionAudit();
				actionAudit.setDescription(QlanResource.get("lock.account.login.fail"));
				actionAudit.setUserName(userName);
				actionAudit.setAuditTypeId(1l);
				actionAudit.setCreateDate(new Date());
				actionAudit.setObjectId(usersDTO.getUserId());
				actionAudit.setServerIp(actionAuditBusinessImpl.getIpServer());
				Long auditId = actionAuditDAO.saveObject(actionAudit);

				AuditDetail auditDetail = new AuditDetail();

				auditDetail.setAuditId(auditId);
				auditDetail.setColName("STATUS");
				auditDetail.setOldValue("1");
				auditDetail.setNewValue("0");
				auditDetail.setTableName("user");

				auditDetailDAO.saveObject(auditDetail);
				resultDTO.setError(true);
				resultDTO.setMessage(QlanResource.get("lock.account.login.fail"));
				resultDTO.setErrorCode(400004);
				return resultDTO;

			}

		}
		
		if(usersDTO.getLastChangePassword() == null){
			resultDTO.setMessage(QlanResource.get("change.password.login.first"));
			resultDTO.setError(false);
			resultDTO.setErrorCode(200001);
			return resultDTO;
		}
		
		if(DateUtil.getDiffDays(usersDTO.getLastChangePassword(), new Date())>=27){
			resultDTO.setMessage(QlanResource.get("change.password.after.27day"));
			resultDTO.setError(false);
			resultDTO.setErrorCode(200001);
			return resultDTO;
		}
		
		String jwt=createJWT(httpSession.getId(), null, userName, 100000000l);
		httpSession.setAttribute("USER_TOKEN", jwt);
		httpSession.setAttribute("userInfo", usersDTO);
		List<ObjectsDTO> listObjParent=objectsDAO.getListObjects(usersDTO.getUserId(), null);
		
		for(ObjectsDTO objParent:listObjParent){
			List<ObjectsDTO> listObjChild=objectsDAO.getListObjects(usersDTO.getUserId(), objParent.getObjectId());
			objParent.setListChildObject(listObjChild);
		}
		
		
		usersDAO.resetLoginFailCount(userName);
		usersDTO.setListObject(listObjParent);
		resultDTO.setError(false);
		resultDTO.setMessage(QlanResource.get("success"));
		resultDTO.setErrorCode(200000);
		resultDTO.setData(usersDTO);
		return resultDTO;
	}
	
	
	private String createJWT(String id, String issuer, String subject, long ttlMillis) {
		 
		
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	 
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	 
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("QLAN");
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	 
	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setId(id)
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);
	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	 
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}

	 private int checkIp(HttpServletRequest req,String ipAddress, String regex, Long checkId){
	        int result = 0;
	        try{
	            if(checkId !=null && checkId == 1L){
	              
	                    result= DataUtils.matchIp(ipAddress,regex);
	               
	            }
	        }catch (Exception e){
	            result=0;
	        }
	        return result;
	    }
	 
	 @Override
	 public ResultDTO changePassword(LoginDTO loginDTO)throws Exception{
		 ResultDTO resultDTO= new ResultDTO();
		 
		 if(StringUtils.isNotEmpty(loginDTO.getUsername()) 
				 && StringUtils.isNotEmpty(loginDTO.getUsername()) 
				 && StringUtils.isNotEmpty(loginDTO.getUsername())
				 && StringUtils.isNotEmpty(loginDTO.getUsername())){
			 UsersDTO usersDTO=usersDAO.getUsersInfo(loginDTO.getUsername());
			 if(null==usersDTO){
				 resultDTO.setError(true);
				 resultDTO.setMessage(QlanResource.get("invalid.account"));
				 return resultDTO;
			 }
			 String hashPassOld=PasswordUtil.hashPassword(loginDTO.getPasswordOld(), "");
			 if(!hashPassOld.equals(usersDTO.getPassword())){
				 resultDTO.setError(true);
				 resultDTO.setMessage(QlanResource.get("invalid.account"));
				 return resultDTO;
			 }
			 if(loginDTO.getPassword().equals(loginDTO.getPasswordOld())){
				 resultDTO.setError(true);
				 resultDTO.setMessage(QlanResource.get("validate.pass.same.oldpass"));
				 return resultDTO;
			 }
			 
			 if(!loginDTO.getPassword().equals(loginDTO.getPasswordConfirm())){
				 resultDTO.setError(true);
				 resultDTO.setMessage(QlanResource.get("validate.pass.not.same.passConfirm"));
				 return resultDTO;
			 }
			 
			 String hashPass=PasswordUtil.hashPassword(loginDTO.getPassword(), "");
			 
			 usersDAO.updatePass(loginDTO.getUsername(), hashPass);
			 
			 
		 } else {
			 resultDTO.setError(true);
			 resultDTO.setMessage(QlanResource.get("validate.data.empty"));
		 }
		 return resultDTO;
	 }
	 
	 
	 public DataListDTO doSearch(UsersDTO obj) {
			List<UsersDTO> ls = usersDAO.doSearch(obj);
			DataListDTO data = new DataListDTO();
			data.setData(ls);
			data.setTotal(obj.getTotalRecord());
			data.setSize(obj.getTotalRecord());
			data.setStart(1);
			return data;
		}

		public Boolean checkUserName(String username, Long appParamId) {
			UsersDTO obj = usersDAO.getUsersInfo(username);

			if (appParamId == null) {
				if (obj == null) {
					return true;
				} else {
					return false;
				}
			} else {
				if (obj == null) {
					return true;
				} else if (obj != null && obj.getUserId().longValue() == appParamId) {
					return true;
				} else {
					return false;
				}
			}

		}
		
		public Boolean checkIsdn(String isdn, Long appParamId) {
			UsersDTO obj = usersDAO.getUsersInfoByIsdn(isdn);

			if (appParamId == null) {
				if (obj == null) {
					return true;
				} else {
					return false;
				}
			} else {
				if (obj == null) {
					return true;
				} else if (obj != null && obj.getUserId().longValue() == appParamId) {
					return true;
				} else {
					return false;
				}
			}

		}
		public Boolean checkEmail(String email, Long appParamId) {
			UsersDTO obj = usersDAO.getUsersInfoByEmail(email);

			if (appParamId == null) {
				if (obj == null) {
					return true;
				} else {
					return false;
				}
			} else {
				if (obj == null) {
					return true;
				} else if (obj != null && obj.getUserId().longValue() == appParamId) {
					return true;
				} else {
					return false;
				}
			}

		}
		
		@Transactional
		public Long add(UsersDTO obj,HttpServletRequest request) throws Exception{
			if(!checkUserName(obj.getUserName(), null)){
				throw new BusinessException(QlanResource.get("dublicate.username"));
			}
			if(!checkIsdn(obj.getTeFax(), null)){
				throw new BusinessException(QlanResource.get("dublicate.isdn"));
			}
			if(!checkEmail(obj.getEmail(), null)){
				throw new BusinessException(QlanResource.get("dublicate.email"));
			}
			HttpSession httpSession =request.getSession();
			UsersDTO userDto= (UsersDTO) httpSession.getAttribute("userInfo");
			String hashPass = PasswordUtil.hashPassword(obj.getPassword(), "");
			obj.setPassword(hashPass);
			obj.setCreateUser(userDto.getUserName());
			obj.setCreateDate(new Date());
			Long id=save(obj);
			actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.INSERT,TABLE_NAME, id, obj, null, QlanResource.get(DISPLAY_NAME_KEY), request);
			return id;
		}
		@Transactional
		public Long updateUsers(UsersDTO obj,HttpServletRequest request) throws Exception{
			if(!checkUserName(obj.getUserName(), obj.getUserId())){
				throw new BusinessException(QlanResource.get("dublicate.username"));
			}
			if(!checkIsdn(obj.getTeFax(), obj.getUserId())){
				throw new BusinessException(QlanResource.get("dublicate.isdn"));
			}
			if(!checkEmail(obj.getEmail(), obj.getUserId())){
				throw new BusinessException(QlanResource.get("dublicate.email"));
			}
			Long id=update(obj);
			UsersDTO objOld = usersDAO.getUsersInfo(obj.getUserName());
			actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.UPDATE,TABLE_NAME, id, obj, objOld, QlanResource.get(DISPLAY_NAME_KEY), request);
			return id;
		}
		@Transactional
		public void lock(List<UsersDTO> listUsers,HttpServletRequest request) throws Exception{
			for(UsersDTO obj:listUsers){
			UsersDTO objOld = usersDAO.getUsersInfo(obj.getUserName());
			if(null==objOld){
				throw new BusinessException(QlanResource.get(ACCOUNT_VI_KEY)+obj.getUserName()+QlanResource.get(INVALID_VI_KEY));
			}
			usersDAO.lockAccount(obj.getUserName());
			actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.LOCK,TABLE_NAME, obj.getUserId(), obj, objOld, QlanResource.get(DISPLAY_NAME_KEY), request);
			}
		}
		
		@Transactional
		public void unlock(List<UsersDTO> listUsers,HttpServletRequest request) throws Exception{
			for(UsersDTO obj:listUsers){
			UsersDTO objOld = usersDAO.getUsersInfo(obj.getUserName());
			if(null==objOld){
				throw new BusinessException(QlanResource.get(ACCOUNT_VI_KEY)+obj.getUserName()+QlanResource.get(INVALID_VI_KEY));
			}
			usersDAO.unlockAccount(obj.getUserName());
			actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.UNLOCK,TABLE_NAME, obj.getUserId(), obj, objOld, QlanResource.get(DISPLAY_NAME_KEY), request);
			}
		}
		@Transactional
		public Long deleteUsers(UsersDTO obj,HttpServletRequest request) throws Exception{
			HttpSession httpSession= request.getSession();
			UsersDTO usersDTO= (UsersDTO) httpSession.getAttribute("userInfo");
			if(obj.getUserName().equals(usersDTO.getUserName())){
				throw new BusinessException(QlanResource.get("validate.user.delete"));
			}
			UsersDTO objOld = usersDAO.getUsersInfo(obj.getUserName());
			if(null==objOld){
				throw new BusinessException(QlanResource.get(ACCOUNT_VI_KEY)+obj.getUserName()+QlanResource.get(INVALID_VI_KEY));
			}
			
			delete(objOld);
			actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.DELETE,TABLE_NAME, obj.getUserId(), null, objOld, QlanResource.get(DISPLAY_NAME_KEY), request);
			return obj.getUserId();
		}
	
		public LoginDTO resetPass(UsersDTO usersDTO,HttpServletRequest request) throws Exception {
			LoginDTO loginDTO= new LoginDTO();
			String pass=PasswordUtil.generateRandomString(8, 3);
			String hashPass=PasswordUtil.hashPassword(pass, "");
			usersDAO.resetPass(usersDTO.getUserId(), hashPass);
			UsersDTO newObj=usersDTO;
			newObj.setPassword(hashPass);
			actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.INSERT,TABLE_NAME, usersDTO.getUserId(), newObj, usersDTO, QlanResource.get(DISPLAY_NAME_KEY), request);
			loginDTO.setPassword(pass);
			return loginDTO;
		}
		
		public UsersDTO checkUserNameExit(String userName){
			return usersDAO.checkUserNameExit(userName);
		}
		
		
		private  String getClientIpAddr(HttpServletRequest request) {  
		    String ip = request.getHeader("X-Forwarded-For");  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("Proxy-Client-IP");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("WL-Proxy-Client-IP");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_X_FORWARDED");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_CLIENT_IP");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_FORWARDED_FOR");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_FORWARDED");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("HTTP_VIA");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getHeader("REMOTE_ADDR");  
		    }  
		    if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
		        ip = request.getRemoteAddr();  
		    }  
		    return ip;  
		}
		
}
