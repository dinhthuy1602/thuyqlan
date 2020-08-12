package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="roles")
@Entity
public class Roles extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "ROLE_ID")
  private Long roleId;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "ROLE_NAME")
  private String roleName;
  @Column(name= "DESCRIPTION")
  private String description;
  @Column(name= "ROLE_CODE")
  private String roleCode;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;
  @Column(name= "CREATE_USER")
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Roles that = (Roles) o;
    return java.util.Objects.equals(roleId, that.roleId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(roleId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
