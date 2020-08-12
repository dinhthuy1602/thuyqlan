package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;
import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="sms_alert")
@Entity
public class SmsAlert extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "SMS_ALERT_ID")
  private Long smsAlertId;
  @Column(name= "ISDN")
  private String isdn;
  @Column(name= "DEPT_ID")
  private Long deptId;
  @Column(name= "STATUS")
  private Long status;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "PROCESS_DATE")
  private Date processDate;
  @Column(name= "SMS_CONTENT")
  private String smsContent;


  public Long getSmsAlertId() {
    return smsAlertId;
  }

  public void setSmsAlertId(Long smsAlertId) {
    this.smsAlertId = smsAlertId;
  }

  public String getIsdn() {
    return isdn;
  }

  public void setIsdn(String isdn) {
    this.isdn = isdn;
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

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getProcessDate() {
    return processDate;
  }

  public void setProcessDate(Date processDate) {
    this.processDate = processDate;
  }

  public String getSmsContent() {
    return smsContent;
  }

  public void setSmsContent(String smsContent) {
    this.smsContent = smsContent;
  }
  @Override
  public String toString() {
   return "sms_alert{"+
     "smsAlertId :" + smsAlertId + ","+
     "isdn :" + isdn + ","+
     "deptId :" + deptId + ","+
     "status :" + status + ","+
     "createDate :" + createDate + ","+
     "processDate :" + processDate + ","+
     "smsContent :" + smsContent + ","+
   "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SmsAlert that = (SmsAlert) o;
    return java.util.Objects.equals(smsAlertId, that.smsAlertId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(smsAlertId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
