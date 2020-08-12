package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.Objects;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @generated automatic by KyPOJO_dto.groovy
 * @Author: kyph
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectsDTO extends QlanBaseDTO<Objects>{
	@AdjHistory(field="OBJECT_ID")
  private Long objectId;
	@AdjHistory(field="PARENT_ID")
  private Long parentId;
	@AdjHistory(field="STATUS")
  private Long status;
	@AdjHistory(field="ORD")
  private Long ord;
	@AdjHistory(field="OBJECT_URL")
  private String objectUrl;
	@AdjHistory(field="OBJECT_NAME")
  private String objectName;
	@AdjHistory(field="DESCRIPTION")
  private String description;
	@AdjHistory(field="OBJECT_TYPE_ID")
  private Long objectTypeId;
	@AdjHistory(field="OBJECT_CODE")
  private String objectCode;
	@AdjHistory(field="CREATE_USER")
  private String createUser;

  private String parentName;
  private boolean lock;
  private Long roleId;
  
  private List<ObjectsDTO> listChildObject;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  @AdjHistory(field="CREATE_DATE")
  private Date createDate;

  public ObjectsDTO() {
  }

  public ObjectsDTO(Objects o, String parentName){
      this.objectId = o.getObjectId();
      this.parentId = o.getParentId();
      this.status = o.getStatus();
      this.ord = o.getOrd();
      this.objectUrl = o.getObjectUrl();
      this.objectName = o.getObjectName();
      this.description = o.getDescription();
      this.objectTypeId = o.getObjectTypeId();
      this.objectCode = o.getObjectCode();
      this.parentName = parentName;
  }

  public ObjectsDTO(Long objectId, Long parentId, Long status, Long ord, String objectUrl, String objectName, String description, Long objectTypeId, String objectCode) {
    this.objectId = objectId;
    this.parentId = parentId;
    this.status = status;
    this.ord = ord;
    this.objectUrl = objectUrl;
    this.objectName = objectName;
    this.description = description;
    this.objectTypeId = objectTypeId;
    this.objectCode = objectCode;

  }

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public Long getOrd() {
    return ord;
  }

  public void setOrd(Long ord) {
    this.ord = ord;
  }

  public String getObjectUrl() {
    return objectUrl;
  }

  public void setObjectUrl(String objectUrl) {
    this.objectUrl = objectUrl;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(Long objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getObjectCode() {
    return objectCode;
  }

  public void setObjectCode(String objectCode) {
    this.objectCode = objectCode;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public List<ObjectsDTO> getListChildObject() {
    return listChildObject;
  }

  public void setListChildObject(List<ObjectsDTO> listChildObject) {
    this.listChildObject = listChildObject;
  }

  public boolean isLock() {
	return lock;
}

public void setLock(boolean lock) {
	this.lock = lock;
}

public Long getRoleId() {
	return roleId;
}

public void setRoleId(Long roleId) {
	this.roleId = roleId;
}

@Override
  public String toString() {
  	return "objects{"+
     "objectId :" + objectId + ","+
     "parentId :" + parentId + ","+
     "status :" + status + ","+
     "ord :" + ord + ","+
     "objectUrl :" + objectUrl + ","+
     "objectName :" + objectName + ","+
     "description :" + description + ","+
     "objectTypeId :" + objectTypeId + ","+
     "objectCode :" + objectCode + ","+
     "createUser :" + createUser + ","+
     "createDate :" + createDate + ","+
   "}";
  }

@Override
public String catchName() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Long getFWModelId() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Objects toModel() {
	Objects obj = new Objects();
    obj.setObjectId(this.getObjectId());
    obj.setObjectCode(this.getObjectCode());
    obj.setObjectName(this.getObjectName());
    obj.setStatus(this.getStatus());
    obj.setParentId(this.getParentId());
    obj.setOrd(this.getOrd());
    obj.setObjectUrl(this.getObjectUrl());
    obj.setDescription(this.getDescription());
    obj.setObjectTypeId(this.getObjectTypeId());
    obj.setCreateDate(this.getCreateDate());
    obj.setCreateUser(this.getCreateUser());
    return  obj;
}
}
