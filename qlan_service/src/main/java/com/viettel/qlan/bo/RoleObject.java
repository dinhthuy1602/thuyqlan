package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="role_object")
@Entity
public class RoleObject extends BaseFWModelImpl{

  @Id
  @Column(name= "OBJECT_ID")
  private Long objectId;
  @Id
  @Column(name= "ROLE_ID")
  private Long roleId;
  @Column(name= "IS_ACTIVE")
  private Long isActive;


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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RoleObject that = (RoleObject) o;
    return java.util.Objects.equals(objectId, that.objectId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(objectId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
