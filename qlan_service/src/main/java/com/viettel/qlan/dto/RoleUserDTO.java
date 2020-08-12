package com.viettel.qlan.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.RoleUser;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleUserDTO extends QlanBaseDTO<RoleUser>{

  private Long roleId;

  private Long userId;

  private Long isActive;

  public Long getStatus() {
	return status;
}

public void setStatus(Long status) {
	this.status = status;
}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getRoleCode() {
	return roleCode;
}

public void setRoleCode(String roleCode) {
	this.roleCode = roleCode;
}

private Long status;
   private String roleName;
   private String description;
   private String roleCode;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getIsActive() {
    return isActive;
  }

  public void setIsActive(Long isActive) {
    this.isActive = isActive;
  }
  
  @Override
  public String toString() {
  	return "role_user{"+
     "roleId :" + roleId + ","+
     "userId :" + userId + ","+
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
public RoleUser toModel() {
	RoleUser roleUser= new RoleUser();
	roleUser.setIsActive(isActive!=null? isActive:1l);
	roleUser.setRoleId(roleId);
	roleUser.setUserId(userId);
	return roleUser;
}


}
