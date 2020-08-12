package com.viettel.qlan.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.viettel.qlan.bo.Dept;
import com.viettel.qlan.bo.Users;
import com.viettel.qlan.dto.DeptDTO;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.utils.ValidateUtils;
import com.viettel.service.base.dao.BaseFWDAOImpl;

@Repository("usersDAO")
public class UsersDAO extends BaseFWDAOImpl<Users, Long> {

	public UsersDAO() {
		this.model = new Users();
	}

	public UsersDAO(Session session) {
		this.session = session;
	}

	
	
	public UsersDTO getUsersInfo(String userName){
		StringBuilder sql = new StringBuilder("SELECT "
				+ "users.USER_ID AS userId,"
				+ "users.USER_NAME AS userName,"
				+"users.FULL_NAME AS fullName, "
				+"users.`PASSWORD` AS password, "
				+"users.EMAIL AS email, "
				+"users.DEPT_ID AS deptId, "
				+"users.`STATUS` AS `status`, "
				+"users.TE_FAX AS teFax, "
				+"users.GENDER AS gender, "
				+"users.BIRTH_PLACE AS birthPlace, "
				+"users.IDENTITY_CARD AS identityCard, "
				+"users.ISSUE_PLACE_IDENT AS issuePlaceIdent, "
				+"users.ISSUE_DATE_IDENT AS issueDateIdent, "
				+"users.DESCRIPTION AS description, "
				+"users.VALID_FROM AS validFrom, "
				+"users.VALID_TO AS validTo, "
				+"users.CHECK_IP AS checkIp, "
				+"users.IP AS ip, "
				+"users.LAST_CHANGE_PASSWORD AS lastChangePassword, "
				+"users.LOGIN_FAILURE_COUNT AS loginFailureCount, "
				+"users.LAST_LOCK_DATE AS lastLockDate "
				+"FROM users "
				+"WHERE upper(users.USER_NAME) = upper(:userName)  " );
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.addScalar("userId", new LongType());
		query.addScalar("userName", new StringType());
		query.addScalar("fullName", new StringType());
		query.addScalar("password", new StringType());
		query.addScalar("email", new StringType());
		query.addScalar("deptId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("teFax", new StringType());
		query.addScalar("gender", new LongType());
		query.addScalar("birthPlace", new StringType());
		query.addScalar("identityCard", new StringType());
		query.addScalar("issuePlaceIdent", new StringType());
		query.addScalar("issueDateIdent", new DateType());
		query.addScalar("description", new StringType());
		query.addScalar("validFrom", new DateType());
		query.addScalar("validTo", new DateType());
		query.addScalar("checkIp", new LongType());
		query.addScalar("ip", new StringType());
		query.addScalar("lastChangePassword", new DateType());
		query.addScalar("loginFailureCount", new LongType());
		query.addScalar("lastLockDate", new DateType());
		
		query.setResultTransformer(Transformers.aliasToBean(UsersDTO.class));
		
		query.setParameter("userName", userName);
		
		return (UsersDTO) query.uniqueResult();
	}
	
	public UsersDTO getUsersInfoByIsdn(String isdn){
		StringBuilder sql = new StringBuilder("SELECT "
				+ "users.USER_ID AS userId,"
				+ "users.USER_NAME AS userName,"
				+"users.FULL_NAME AS fullName, "
				+"users.`PASSWORD` AS password, "
				+"users.EMAIL AS email, "
				+"users.DEPT_ID AS deptId, "
				+"users.`STATUS` AS `status`, "
				+"users.TE_FAX AS teFax, "
				+"users.GENDER AS gender, "
				+"users.BIRTH_PLACE AS birthPlace, "
				+"users.IDENTITY_CARD AS identityCard, "
				+"users.ISSUE_PLACE_IDENT AS issuePlaceIdent, "
				+"users.ISSUE_DATE_IDENT AS issueDateIdent, "
				+"users.DESCRIPTION AS description, "
				+"users.VALID_FROM AS validFrom, "
				+"users.VALID_TO AS validTo, "
				+"users.CHECK_IP AS checkIp, "
				+"users.IP AS ip, "
				+"users.LAST_CHANGE_PASSWORD AS lastChangePassword, "
				+"users.LOGIN_FAILURE_COUNT AS loginFailureCount, "
				+"users.LAST_LOCK_DATE AS lastLockDate "
				+"FROM users "
				+"WHERE upper(users.TE_FAX) = upper(:isdn)  " );
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.addScalar("userId", new LongType());
		query.addScalar("userName", new StringType());
		query.addScalar("fullName", new StringType());
		query.addScalar("password", new StringType());
		query.addScalar("email", new StringType());
		query.addScalar("deptId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("teFax", new StringType());
		query.addScalar("gender", new LongType());
		query.addScalar("birthPlace", new StringType());
		query.addScalar("identityCard", new StringType());
		query.addScalar("issuePlaceIdent", new StringType());
		query.addScalar("issueDateIdent", new DateType());
		query.addScalar("description", new StringType());
		query.addScalar("validFrom", new DateType());
		query.addScalar("validTo", new DateType());
		query.addScalar("checkIp", new LongType());
		query.addScalar("ip", new StringType());
		query.addScalar("lastChangePassword", new DateType());
		query.addScalar("loginFailureCount", new LongType());
		query.addScalar("lastLockDate", new DateType());
		
		query.setResultTransformer(Transformers.aliasToBean(UsersDTO.class));
		
		query.setParameter("isdn", isdn);
		
		return (UsersDTO) query.uniqueResult();
	}
	public UsersDTO getUsersInfoByEmail(String email){
		StringBuilder sql = new StringBuilder("SELECT "
				+ "users.USER_ID AS userId,"
				+ "users.USER_NAME AS userName,"
				+"users.FULL_NAME AS fullName, "
				+"users.`PASSWORD` AS password, "
				+"users.EMAIL AS email, "
				+"users.DEPT_ID AS deptId, "
				+"users.`STATUS` AS `status`, "
				+"users.TE_FAX AS teFax, "
				+"users.GENDER AS gender, "
				+"users.BIRTH_PLACE AS birthPlace, "
				+"users.IDENTITY_CARD AS identityCard, "
				+"users.ISSUE_PLACE_IDENT AS issuePlaceIdent, "
				+"users.ISSUE_DATE_IDENT AS issueDateIdent, "
				+"users.DESCRIPTION AS description, "
				+"users.VALID_FROM AS validFrom, "
				+"users.VALID_TO AS validTo, "
				+"users.CHECK_IP AS checkIp, "
				+"users.IP AS ip, "
				+"users.LAST_CHANGE_PASSWORD AS lastChangePassword, "
				+"users.LOGIN_FAILURE_COUNT AS loginFailureCount, "
				+"users.LAST_LOCK_DATE AS lastLockDate "
				+"FROM users "
				+"WHERE upper(users.EMAIL) = upper(:email)  " );
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.addScalar("userId", new LongType());
		query.addScalar("userName", new StringType());
		query.addScalar("fullName", new StringType());
		query.addScalar("password", new StringType());
		query.addScalar("email", new StringType());
		query.addScalar("deptId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("teFax", new StringType());
		query.addScalar("gender", new LongType());
		query.addScalar("birthPlace", new StringType());
		query.addScalar("identityCard", new StringType());
		query.addScalar("issuePlaceIdent", new StringType());
		query.addScalar("issueDateIdent", new DateType());
		query.addScalar("description", new StringType());
		query.addScalar("validFrom", new DateType());
		query.addScalar("validTo", new DateType());
		query.addScalar("checkIp", new LongType());
		query.addScalar("ip", new StringType());
		query.addScalar("lastChangePassword", new DateType());
		query.addScalar("loginFailureCount", new LongType());
		query.addScalar("lastLockDate", new DateType());
		
		query.setResultTransformer(Transformers.aliasToBean(UsersDTO.class));
		
		query.setParameter("email", email);
		
		return (UsersDTO) query.uniqueResult();
	}
	
	public void updateLoginFailCount(String userName){
		StringBuilder sql = new StringBuilder("UPDATE users SET LOGIN_FAILURE_COUNT=COALESCE(LOGIN_FAILURE_COUNT,0)+1 WHERE USER_NAME=:userName ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.setParameter("userName", userName);
		
		query.executeUpdate();
	}
	
	public void resetLoginFailCount(String userName){
		StringBuilder sql = new StringBuilder("UPDATE users SET LOGIN_FAILURE_COUNT=0 WHERE USER_NAME=:userName ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.setParameter("userName", userName);
		
		query.executeUpdate();
	}
	
	
	public void lockAccount(String userName){
		StringBuilder sql = new StringBuilder("UPDATE users SET STATUS=0,LAST_LOCK_DATE= SYSDATE() WHERE USER_NAME=:userName ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.setParameter("userName", userName);
		
		query.executeUpdate();
		
		
	}
	
	public void unlockAccount(String userName){
		StringBuilder sql = new StringBuilder("UPDATE users SET STATUS=1,LOGIN_FAILURE_COUNT=0 WHERE USER_NAME=:userName ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.setParameter("userName", userName);
		
		query.executeUpdate();
		
		
	}
	
	public void updatePass(String userName,String pass){
		StringBuilder sql = new StringBuilder("UPDATE users SET PASSWORD=:pass,LAST_CHANGE_PASSWORD=SYSDATE() WHERE USER_NAME=:userName ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.setParameter("userName", userName);
		query.setParameter("pass", pass);
		query.executeUpdate();
	}
	
	public void resetPass(Long userId,String pass){
		StringBuilder sql = new StringBuilder("UPDATE users SET PASSWORD=:pass,LAST_CHANGE_PASSWORD=null,LOGIN_FAILURE_COUNT=0 WHERE USER_ID=:userId ");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.setParameter("userId", userId);
		query.setParameter("pass", pass);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<UsersDTO> doSearch(UsersDTO obj){
		StringBuilder sql = new StringBuilder("SELECT "
				+ "users.USER_ID AS userId,"
				+ "users.USER_NAME AS userName,"
				+"users.FULL_NAME AS fullName, "
				+"users.`PASSWORD` AS password, "
				+"users.EMAIL AS email, "
				+"users.DEPT_ID AS deptId, "
				+"users.`STATUS` AS `status`, "
				+"users.TE_FAX AS teFax, "
				+"users.GENDER AS gender, "
				+"users.BIRTH_PLACE AS birthPlace, "
				+"users.IDENTITY_CARD AS identityCard, "
				+"users.ISSUE_PLACE_IDENT AS issuePlaceIdent, "
				+"users.ISSUE_DATE_IDENT AS issueDateIdent, "
				+"users.DESCRIPTION AS description, "
				+"users.VALID_FROM AS validFrom, "
				+"users.VALID_TO AS validTo, "
				+"users.CHECK_IP AS checkIp, "
				+"users.IP AS ip, "
				+"users.LAST_CHANGE_PASSWORD AS lastChangePassword, "
				+"users.LOGIN_FAILURE_COUNT AS loginFailureCount, "
				+"users.LAST_LOCK_DATE AS lastLockDate , "
				+ "users.DATE_OF_BIRTH AS dateOfBirth,"
				+ "dept.DEPT_NAME AS deptName "
				+"FROM users "
				+ "LEFT JOIN dept ON dept.DEPT_ID=users.DEPT_ID "
				+"WHERE 1=1 ");
		
		if(StringUtils.isNotEmpty(obj.getUserName())){
			sql.append(" AND upper(users.USER_NAME) LIKE upper(:userName) escape '&'  ");
		}
		
		if(StringUtils.isNotEmpty(obj.getFullName())){
			sql.append("  AND upper(users.FULL_NAME) LIKE upper(:fullName)  escape '&' ");
		}
		
		if(obj.getDeptId() != null){
			sql.append(" AND users.DEPT_ID = :deptId");
		}
		if(obj.getStatus() != null ){
			sql.append(" AND users.`STATUS` = :status");
		}
		
		if(StringUtils.isNotEmpty(obj.getTeFax())){
			sql.append(" AND upper(users.TE_FAX) LIKE upper(:teFax) escape '&'  ");
		}
		
		sql.append(" ORDER BY users.USER_NAME,users.FULL_NAME");
		
		StringBuilder sqlCount = new StringBuilder("SELECT COUNT(*) FROM (");
		sqlCount.append(sql.toString());
		sqlCount.append(")");
		sqlCount.append(" as objects;");
		
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		SQLQuery queryCount=getSession().createSQLQuery(sqlCount.toString());
		
		
		query.addScalar("userId", new LongType());
		query.addScalar("userName", new StringType());
		query.addScalar("fullName", new StringType());
		query.addScalar("password", new StringType());
		query.addScalar("email", new StringType());
		query.addScalar("deptId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("teFax", new StringType());
		query.addScalar("gender", new LongType());
		query.addScalar("birthPlace", new StringType());
		query.addScalar("identityCard", new StringType());
		query.addScalar("issuePlaceIdent", new StringType());
		query.addScalar("issueDateIdent", new DateType());
		query.addScalar("description", new StringType());
		query.addScalar("validFrom", new DateType());
		query.addScalar("validTo", new DateType());
		query.addScalar("checkIp", new LongType());
		query.addScalar("ip", new StringType());
		query.addScalar("lastChangePassword", new DateType());
		query.addScalar("loginFailureCount", new LongType());
		query.addScalar("lastLockDate", new DateType());
		query.addScalar("dateOfBirth", new DateType());
		query.addScalar("deptName", new StringType());
		
		query.setResultTransformer(Transformers.aliasToBean(UsersDTO.class));
		if(StringUtils.isNotEmpty(obj.getUserName())){
		query.setParameter("userName", "%"+ ValidateUtils.validateKeySearch(obj.getUserName())+"%");
		queryCount.setParameter("userName", "%"+ ValidateUtils.validateKeySearch(obj.getUserName())+"%");
		}
		if(obj.getStatus() != null){
			query.setParameter("status", obj.getStatus());
			queryCount.setParameter("status", obj.getStatus());
		}
		if(obj.getDeptId() != null){
			query.setParameter("deptId", obj.getDeptId());
			queryCount.setParameter("deptId", obj.getDeptId());
		}
		if(StringUtils.isNotEmpty(obj.getFullName())){
			query.setParameter("fullName",  "%"+ ValidateUtils.validateKeySearch(obj.getFullName())+"%");
			queryCount.setParameter("fullName",  "%"+ ValidateUtils.validateKeySearch(obj.getFullName())+"%");
		}
		if(StringUtils.isNotEmpty(obj.getTeFax())){
			query.setParameter("teFax", "%"+ ValidateUtils.validateKeySearch(obj.getTeFax())+"%");
			queryCount.setParameter("teFax", "%"+ ValidateUtils.validateKeySearch(obj.getTeFax())+"%");
		}
		
		query.setFirstResult((obj.getPage().intValue()-1)*obj.getPageSize().intValue());
		query.setMaxResults(obj.getPageSize().intValue());
		obj.setTotalRecord(((BigInteger)queryCount.uniqueResult()).intValue());
		
		return query.list();
	}
	
	public UsersDTO checkUserNameExit(String userName){
		StringBuilder sql = new StringBuilder("SELECT "
				+ "users.USER_ID AS userId,"
				+ "users.USER_NAME AS userName,"
				+"users.FULL_NAME AS fullName, "
				+"users.`PASSWORD` AS password, "
				+"users.EMAIL AS email, "
				+"users.DEPT_ID AS deptId, "
				+"users.`STATUS` AS `status`, "
				+"users.TE_FAX AS teFax, "
				+"users.GENDER AS gender, "
				+"users.BIRTH_PLACE AS birthPlace, "
				+"users.IDENTITY_CARD AS identityCard, "
				+"users.ISSUE_PLACE_IDENT AS issuePlaceIdent, "
				+"users.ISSUE_DATE_IDENT AS issueDateIdent, "
				+"users.DESCRIPTION AS description, "
				+"users.VALID_FROM AS validFrom, "
				+"users.VALID_TO AS validTo, "
				+"users.CHECK_IP AS checkIp, "
				+"users.IP AS ip, "
				+"users.LAST_CHANGE_PASSWORD AS lastChangePassword, "
				+"users.LOGIN_FAILURE_COUNT AS loginFailureCount, "
				+"users.LAST_LOCK_DATE AS lastLockDate "
				+"FROM users "
				+"WHERE upper(users.USER_NAME) = upper(:userName)  AND users.`STATUS`=1 " );
		SQLQuery query= getSession().createSQLQuery(sql.toString());
		
		query.addScalar("userId", new LongType());
		query.addScalar("userName", new StringType());
		query.addScalar("fullName", new StringType());
		query.addScalar("password", new StringType());
		query.addScalar("email", new StringType());
		query.addScalar("deptId", new LongType());
		query.addScalar("status", new LongType());
		query.addScalar("teFax", new StringType());
		query.addScalar("gender", new LongType());
		query.addScalar("birthPlace", new StringType());
		query.addScalar("identityCard", new StringType());
		query.addScalar("issuePlaceIdent", new StringType());
		query.addScalar("issueDateIdent", new DateType());
		query.addScalar("description", new StringType());
		query.addScalar("validFrom", new DateType());
		query.addScalar("validTo", new DateType());
		query.addScalar("checkIp", new LongType());
		query.addScalar("ip", new StringType());
		query.addScalar("lastChangePassword", new DateType());
		query.addScalar("loginFailureCount", new LongType());
		query.addScalar("lastLockDate", new DateType());
		
		query.setResultTransformer(Transformers.aliasToBean(UsersDTO.class));
		
		query.setParameter("userName", userName);
		
		return (UsersDTO) query.uniqueResult();
	}
}
