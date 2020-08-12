package com.viettel.qlan.bo;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="staff_cbv")
@Entity
public class StaffCbv extends BaseFWModelImpl{
	 public StaffCbv() {
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
  @Column(name= "TEL2")
  private String tel2;
  @Column(name= "DEPT_CODE")
  private String deptCode;
  @Column(name= "ID_NO")
  private String idNo;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "LEVEL")
  private Long level;


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

  
  

  public String getTel2() {
	return tel2;
}

public void setTel2(String tel2) {
	this.tel2 = tel2;
}

public String getDeptCode() {
	return deptCode;
}

public void setDeptCode(String deptCode) {
	this.deptCode = deptCode;
}

public String getIdNo() {
	return idNo;
}

public void setIdNo(String idNo) {
	this.idNo = idNo;
}

public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }
  
  public Long getLevel() {
	return level;
}

public void setLevel(Long level) {
	this.level = level;
}

@Override
  public String toString() {
   return "user_alerts{"+
     "staffId :" + staffId + ","+
     "staffCode :" + staffCode + ","+
     "name :" + name + ","+
     "tel :" + tel + ","+
     "tel2 :" + tel2 + ","+
     "deptCode :" + deptCode + ","+
     "idNo :" + idNo + ","+
     "status :" + status + ","+
   "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StaffCbv that = (StaffCbv) o;
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
