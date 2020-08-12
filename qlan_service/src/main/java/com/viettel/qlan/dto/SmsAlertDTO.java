package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.SmsAlert;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class SmsAlertDTO extends QlanBaseDTO<SmsAlert>{

  private Long smsAlertId;

  private String isdn;

  private Long deptId;

  private Long status;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date createDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date processDate;

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
public SmsAlert toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
