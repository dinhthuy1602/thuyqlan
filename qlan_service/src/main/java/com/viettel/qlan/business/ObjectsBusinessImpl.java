package com.viettel.qlan.business;


import com.viettel.base.common.BusinessException;
import com.viettel.qlan.bo.Objects;
import com.viettel.qlan.bo.Users;
import com.viettel.qlan.constant.Constants;
import com.viettel.qlan.dao.ObjectsDAO;
import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.utils.QlanResource;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import com.viettel.service.base.dto.DataListDTO;
import oracle.net.ns.BreakNetException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import com.viettel.qlan.utils.ObjectsValidate;

@Service("objectsBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ObjectsBusinessImpl extends BaseFWBusinessImpl<ObjectsDAO, ObjectsDTO, Objects> implements ObjectsBusiness {

//    private static final Logger log = Logger.getLogger(ObjectsBusinessImpl.class);
//    private static String INVALID_ACC_KEY="invalid.account";
//    private static String DISPLAY_NAME_KEY="mng_objects";
//    private static String TABLE_NAME="OBJECTS";
//    private static String OBJECT_VI_KEY="object_vi";
//    private static String INVALID_VI_KEY="invalid_vi";


    @Autowired
    private ObjectsDAO objectsDAO;
    @Autowired
    ActionAuditBusinessImpl actionAuditBusinessImpl;

    public ObjectsBusinessImpl() {
        tModel = new Objects();
        tDAO = objectsDAO;
    }

    @Override
    public ObjectsDAO gettDAO() {
        return objectsDAO;
    }

    @Override
    public DataListDTO doSearch(ObjectsDTO obj) {
        List<ObjectsDTO> list = objectsDAO.doSearch(obj);
        DataListDTO data = new DataListDTO();
        data.setData(list);
        data.setTotal(obj.getTotalRecord());
        data.setSize(obj.getTotalRecord());
        data.setStart(1);
        return data;
    }

    @Override
    public List<ObjectsDTO> autoSearchObjects (ObjectsDTO obj){
//        List<ObjectsDTO> list = objectsDAO.autoSearchObjects(obj);
//        DataListDTO data = new DataListDTO();
//        data.setData(list);
//        return data;
        List<ObjectsDTO> data = objectsDAO.autoSearchObjects(obj);
        return data;
    }

    @Override
    public List<ObjectsDTO> autoSearchObjectsPopup (ObjectsDTO obj){
        List<ObjectsDTO> data = objectsDAO.autoSearchObjectsPopup(obj);
        return data;
    }


    public boolean checkObjectsCode(ObjectsDTO objectsDTO, Long appParamId){
        ObjectsDTO obj = objectsDAO.getObjectsInfoByCode(objectsDTO);
        if (appParamId == null){
            if (obj==null){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if(obj==null){
                return true;
            }else if(obj != null && obj.getObjectId().longValue() == appParamId){
                return true;
            } else{
                return false;
            }
        }
    }

    public boolean checkObjectsId(ObjectsDTO objectsDTO, Long appParamId){
        ObjectsDTO obj = objectsDAO.getObjectsInfoById(objectsDTO);
        if (appParamId == null){
            if (obj==null){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if(obj==null){
                return true;
            }else if(obj != null && obj.getObjectId().longValue() == appParamId){
                return true;
            } else{
                return false;
            }
        }
    }

    public String checkObjectsValidate(ObjectsDTO objectsDTO){
        ObjectsValidate objectsValidate = new ObjectsValidate();
        //Kiểm tra vilidate mã chức năng
        if(null == objectsDTO.getObjectCode() ){
            return "objects_code_not_null";
        }else {
            if(objectsValidate.specialUnderscore(objectsDTO.getObjectCode())){
                return "objects_code_not_space";
            }
            if (objectsValidate.specialCharacterCode(objectsDTO.getObjectCode())) {
                return "objects_code_special";
            }
            if (objectsValidate.vietNameseCheck(objectsDTO.getObjectCode())) {
                return "objects_code_not_vietnamese";
            }
            if (objectsValidate.htmlCheck(objectsDTO.getObjectCode())) {
                return "objects_code_not_html";
            }
            if (objectsValidate.lengthCheck(objectsDTO.getObjectCode(), 100)) {
                return "objects_code_max_length";
            }
        }

        //Kiểm tra validate tên chức năng
        if (null == objectsDTO.getObjectName()) {
            return "object_name_not_null";
        } else {
            if (objectsValidate.htmlCheck(objectsDTO.getObjectName())) {
                return "object_name_not_html";
            }
            if (objectsValidate.lengthCheck(objectsDTO.getObjectName(), 200)) {
                return "object_name_max_length";
            }
        }

        //kiểm tra validate Url
        if (null == objectsDTO.getObjectUrl()) {
            return "object_url_not_null";
        } else {
            if (objectsValidate.vietNameseCheck(objectsDTO.getObjectUrl())) {
                return "object_url_not_vietnamese";
            }
            if (objectsValidate.htmlCheck(objectsDTO.getObjectUrl())) {
                return "object_url_not_html";
            }
            if (objectsValidate.lengthCheck(objectsDTO.getObjectUrl(), 300)) {
                return "object_url_max_length";
            }
        }

        //Kiểm tra validate thứ tự
        if (null != objectsDTO.getOrd()) {
            if (objectsValidate.validateNumber(Long.toString(objectsDTO.getOrd())) || objectsDTO.getOrd()==-1){
                return "object_ord_number";
            }
            if (objectsValidate.lengthCheck(Long.toString(objectsDTO.getOrd()), 11)) {
                return "object_ord_max_length";
            }
        }

        //kiểm tra validate Mô tả
        if (null != objectsDTO.getDescription()){
            if(objectsValidate.htmlCheck(objectsDTO.getDescription())){
                return "object_description_not_html";
            }
            if(objectsValidate.lengthCheck(objectsDTO.getDescription(), 1000)){
                return "object_description_max_length";
            }
        }
        return null;
    }



    @Override
    @Transactional
    public Long add(ObjectsDTO obj, HttpServletRequest request) throws Exception {
        if(!checkObjectsCode(obj, null)){
            throw new BusinessException((QlanResource.get("objects_code_exits")));
        }
        if(!checkObjectsId(obj, null)){
            throw new BusinessException((QlanResource.get("objects_id_exits")));
        }
        if (null!=checkObjectsValidate(obj)){
            throw new BusinessException(QlanResource.get(checkObjectsValidate(obj)));
        }
        try{
            Long id=save(obj);
            return id;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public Long updateObjects(ObjectsDTO obj, HttpServletRequest request) throws Exception {
        ObjectsDTO objOld = objectsDAO.getObjectsInfoById(obj);
        List<ObjectsDTO> objectsRolesList = objectsDAO.checkRolesObject(obj.getObjectId());
        if(null == objOld){
            throw new BusinessException(QlanResource.get("objects_update_not_exits"));
        }else{
            if(!objOld.getObjectCode().equals(obj.getObjectCode())){
                throw new BackingStoreException(QlanResource.get("object_update_check_code"));
            }
            if (objOld.getObjectId()== 200 && obj.getStatus() == 0){
                throw new BusinessException(QlanResource.get("object_lock_not_management"));
            }
            if(!checkObjectsCode(obj, obj.getObjectId())){
                throw new BusinessException(QlanResource.get("objects_code_exits"));
            }
            if(!checkObjectsId(obj, obj.getObjectId())){
                throw new BusinessException((QlanResource.get("objects_id_exits")));
            }
            if (objectsRolesList.size() > 0  ){
                throw new BusinessException(QlanResource.get("object_lock_check_role"));
            }
            if (null!=checkObjectsValidate(obj)){
                throw new BusinessException(QlanResource.get(checkObjectsValidate(obj)));
            }
        }
        try{
            Long id=update(obj);
            //actionAuditBusinessImpl.trackingAdjustment(Constants.ACTION_AUDIT_TYPE.UPDATE,TABLE_NAME, id, obj, objOld, QlanResource.get(DISPLAY_NAME_KEY), request);
            return id;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public Long lock(ObjectsDTO objectsDTO, HttpServletRequest request) throws Exception{
        ObjectsDTO objOld = objectsDAO.getObjectsInfoById(objectsDTO);
       List<ObjectsDTO> objectsRolesList = objectsDAO.checkRolesObject(objectsDTO.getObjectId());
        if(objOld==null){
            throw new BusinessException(QlanResource.get("object_lock_not_exits"));
        }
        if (objOld.getObjectId()== 200 && objectsDTO.getStatus() == 0){
            throw new BusinessException(QlanResource.get("object_lock_not_management"));
        }
        if (objectsRolesList.size() > 0  ){
            throw new BusinessException(QlanResource.get("object_lock_check_role"));
        }
        try{
            objectsDAO.lockObject(objectsDTO.getObjectId());
            return objOld.getObjectId();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("");
        }

    }

    @Override
    @Transactional
    public Long unlock(ObjectsDTO objectsDTO, HttpServletRequest request) throws Exception{
        ObjectsDTO objOld = objectsDAO.getObjectsInfoById(objectsDTO);
        if(objOld==null){
            throw new BusinessException(QlanResource.get("object_unlock_not_exits"));
        }
        try {
            objectsDAO.unlockObject(objectsDTO.getObjectId());
            return objectsDTO.getObjectId();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("");
        }

    }

    @Override
    @Transactional
    public Long deleteObjects(ObjectsDTO obj, HttpServletRequest request) throws Exception {
        ObjectsDTO objOld = objectsDAO.getObjectsInfoById(obj);
       List<ObjectsDTO> objectsRolesList = objectsDAO.checkRolesObject(obj.getObjectId());
        if (objOld == null) {
            throw new BusinessException(QlanResource.get("object_delete_not_exits"));
            //throw new BusinessException(QlanResource.get(OBJECT_VI_KEY)+" "+obj.getObjectName()+" "+QlanResource.get(INVALID_VI_KEY));
        }
        if (objOld.getObjectId() == 200) {
            throw new BusinessException(QlanResource.get("object_delete_not_management"));
        }
        if (objectsRolesList.size() > 0) {
            throw new BusinessException(QlanResource.get("object_delete_not_role"));
        }
        try {
            delete(objOld);
            return obj.getObjectId();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("");
        }
    }
}
