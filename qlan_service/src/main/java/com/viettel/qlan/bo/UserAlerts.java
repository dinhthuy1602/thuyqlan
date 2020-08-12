package com.viettel.qlan.bo;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="user_alerts")
@Entity
public class UserAlerts extends BaseFWModelImpl{
	 public UserAlerts() {
	        setColId("staffId");
	        setColName("staffId");
	        setUniqueColumn(new String[]{"staffId"});
	}

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name= "STAFF_ID")
  private Long staffId;
  @Column(name= "STAFF_CODE")
  private String staffCode;
  @Column(name= "NAME")
  private String name;
  @Column(name= "TEL")
  private String tel;
  @Column(name= "EMAIL")
  private String email;
  @Column(name= "DEPT_ID")
  private Long deptId;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "WARNING_LEVEL")
  private Long warningLevel;


  public Long getStaffId() {
    return staffId;
  }

  public void setStaffId(Long staffId) {
    this.staffId = staffId;
  }

  public String getStaffCode() {
    return staffCode;
  }

  public void setStaffCode(String staffCode) {
    this.staffCode = staffCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }
  
  
  public Long getWarningLevel() {
	return warningLevel;
}

public void setWarningLevel(Long warningLevel) {
	this.warningLevel = warningLevel;
}

@Override
  public String toString() {
   return "user_alerts{"+
     "staffId :" + staffId + ","+
     "staffCode :" + staffCode + ","+
     "name :" + name + ","+
     "tel :" + tel + ","+
     "email :" + email + ","+
     "deptId :" + deptId + ","+
     "status :" + status + ","+
   "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserAlerts that = (UserAlerts) o;
    return java.util.Objects.equals(staffId, that.staffId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(staffId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
