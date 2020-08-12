package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.qlan.dto.RoleUserDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="role_user")
@Entity
public class RoleUser extends BaseFWModelImpl{

  @Id
  @Column(name= "ROLE_ID")
  private Long roleId;
  @Id
  @Column(name= "USER_ID")
  private Long userId;
  @Column(name= "IS_ACTIVE")
  private Long isActive;


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
public RoleUserDTO toDTO() {
	RoleUserDTO roleUser= new RoleUserDTO();
	roleUser.setIsActive(isActive!=null? isActive:1l);
	roleUser.setRoleId(roleId);
	roleUser.setUserId(userId);
	return roleUser;
}

}
