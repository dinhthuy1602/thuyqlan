package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.Roles;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class RolesDTO extends QlanBaseDTO<Roles>{
	@AdjHistory(field="ROLE_ID")
  private Long roleId;
	@AdjHistory(field="STATUS")
  private Long status;
	@AdjHistory(field="ROLE_NAME")
  private String roleName;
	@AdjHistory(field="DESCRIPTION")
  private String description;
	@AdjHistory(field="ROLE_CODE")
  private String roleCode;
	private Long objectId;
	private List<RoleObjectDTO> listObject=Lists.newArrayList();
	private List<Long> listId=Lists.newArrayList();
  public List<Long> getListId() {
		return listId;
	}

	public void setListId(List<Long> listId) {
		this.listId = listId;
	}

public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

public List<RoleObjectDTO> getListObject() {
		return listObject;
	}

	public void setListObject(List<RoleObjectDTO> listObject) {
		this.listObject = listObject;
	}

private boolean lock;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  @AdjHistory(field="CREATE_DATE")
  private Date createDate;
  @AdjHistory(field="CREATE_USER")
  private String createUser;


  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

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

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }
  
  public boolean isLock() {
	return lock;
}

public void setLock(boolean lock) {
	this.lock = lock;
}

@Override
  public String toString() {
  	return "roles{"+
     "roleId :" + roleId + ","+
     "status :" + status + ","+
     "roleName :" + roleName + ","+
     "description :" + description + ","+
     "roleCode :" + roleCode + ","+
     "createDate :" + createDate + ","+
     "createUser :" + createUser + ","+
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
public Roles toModel() {
	Roles r = new Roles();
	r.setRoleId(this.roleId);
	r.setRoleCode(this.roleCode);
	r.setRoleName(this.roleName);
	r.setCreateDate(this.createDate);
	r.setCreateUser(this.createUser);
	r.setStatus(this.status);
	r.setDescription(this.description);
	return r;
}

}
