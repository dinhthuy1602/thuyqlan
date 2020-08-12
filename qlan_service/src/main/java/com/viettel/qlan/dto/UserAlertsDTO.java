package com.viettel.qlan.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.UserAlerts;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "USERALERTSBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAlertsDTO extends QlanBaseDTO<UserAlerts>{

	@AdjHistory(field="STAFF_ID")
  private Long staffId;
	@AdjHistory(field="STAFF_CODE")
  private String staffCode;
	@AdjHistory(field="NAME")
  private String name;
	@AdjHistory(field="TEL")
  private String tel;
	@AdjHistory(field="EMAIL")
  private String email;
	@AdjHistory(field="DEPT_ID")
  private Long deptId;
	@AdjHistory(field="WARNING_LEVEL")
	private Long warningLevel;
	private String warningLevelName;
  private Long status;
  private String deptName;

  public UserAlertsDTO() {
  }

  public UserAlertsDTO(Long staffId, String staffCode, String name, String tel, String email, Long deptId, Long status, String deptName) {
    this.staffId = staffId;
    this.staffCode = staffCode;
    this.name = name;
    this.tel = tel;
    this.email = email;
    this.deptId = deptId;
    this.status = status;
    this.deptName = deptName;
  }

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

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public String getWarningLevelName() {
	return warningLevelName;
}

public void setWarningLevelName(String warningLevelName) {
	this.warningLevelName = warningLevelName;
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
public String catchName() {
	// TODO Auto-generated method stub
	return staffId.toString();
}

@Override
public Long getFWModelId() {
	return staffId;
}

public Long getWarningLevel() {
	return warningLevel;
}

public void setWarningLevel(Long warningLevel) {
	this.warningLevel = warningLevel;
}

@Override
public UserAlerts toModel() {
	UserAlerts u = new UserAlerts();
	u.setStaffId(this.staffId);
	u.setStaffCode(this.staffCode);
	u.setStatus(this.status);
	u.setDeptId(this.deptId);
	u.setTel(this.tel);
	u.setName(this.name);
	u.setEmail(this.email);
	u.setWarningLevel(this.warningLevel);
	return u;
}

}
