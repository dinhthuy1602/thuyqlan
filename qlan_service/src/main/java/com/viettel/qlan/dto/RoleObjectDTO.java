package com.viettel.qlan.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.viettel.qlan.bo.RoleObject;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleObjectDTO extends QlanBaseDTO<RoleObject>{

  private Long objectId;

  private Long roleId;

  private Long isActive;
  private String objectCode;
  private String objectName;
  private Long ord;
  private Long objectTypeId;
  private String objectUrl;
  


  public String getObjectCode() {
	return objectCode;
}

public void setObjectCode(String objectCode) {
	this.objectCode = objectCode;
}

public String getObjectName() {
	return objectName;
}

public void setObjectName(String objectName) {
	this.objectName = objectName;
}

public Long getOrd() {
	return ord;
}

public void setOrd(Long ord) {
	this.ord = ord;
}

public Long getObjectTypeId() {
	return objectTypeId;
}

public void setObjectTypeId(Long objectTypeId) {
	this.objectTypeId = objectTypeId;
}

public String getObjectUrl() {
	return objectUrl;
}

public void setObjectUrl(String objectUrl) {
	this.objectUrl = objectUrl;
}

public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getIsActive() {
    return isActive;
  }

  public void setIsActive(Long isActive) {
    this.isActive = isActive;
  }
  @Override
  public String toString() {
  	return "role_object{"+
     "objectId :" + objectId + ","+
     "roleId :" + roleId + ","+
     "isActive :" + isActive + ","+
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
public RoleObject toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
