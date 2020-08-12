package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.ReqOcIsdnEx;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class ReqOcIsdnExDTO extends QlanBaseDTO<ReqOcIsdnEx>{

  private Long reqOcIsdnExId;

  private Long reqOcId;

  private Long reqOcIsdnId;

  private String ocIsdn;

  private String isdnEx;

  private Long customerId;

  private String cusName;

  private String idNo;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date idIssueDate;

  private String idIssuePlace;

  private Long status;

  private String type;

  private String address;

  private String vhrIdNo;

  private String vhrName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date vhrBirthdate;

  private String vhrDeptName;


  public Long getReqOcIsdnExId() {
    return reqOcIsdnExId;
  }

  public void setReqOcIsdnExId(Long reqOcIsdnExId) {
    this.reqOcIsdnExId = reqOcIsdnExId;
  }

  public Long getReqOcId() {
    return reqOcId;
  }

  public void setReqOcId(Long reqOcId) {
    this.reqOcId = reqOcId;
  }

  public Long getReqOcIsdnId() {
    return reqOcIsdnId;
  }

  public void setReqOcIsdnId(Long reqOcIsdnId) {
    this.reqOcIsdnId = reqOcIsdnId;
  }

  public String getOcIsdn() {
    return ocIsdn;
  }

  public void setOcIsdn(String ocIsdn) {
    this.ocIsdn = ocIsdn;
  }

  public String getIsdnEx() {
    return isdnEx;
  }

  public void setIsdnEx(String isdnEx) {
    this.isdnEx = isdnEx;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getCusName() {
    return cusName;
  }

  public void setCusName(String cusName) {
    this.cusName = cusName;
  }

  public String getIdNo() {
    return idNo;
  }

  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  public Date getIdIssueDate() {
    return idIssueDate;
  }

  public void setIdIssueDate(Date idIssueDate) {
    this.idIssueDate = idIssueDate;
  }

  public String getIdIssuePlace() {
    return idIssuePlace;
  }

  public void setIdIssuePlace(String idIssuePlace) {
    this.idIssuePlace = idIssuePlace;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getVhrIdNo() {
    return vhrIdNo;
  }

  public void setVhrIdNo(String vhrIdNo) {
    this.vhrIdNo = vhrIdNo;
  }

  public String getVhrName() {
    return vhrName;
  }

  public void setVhrName(String vhrName) {
    this.vhrName = vhrName;
  }

  public Date getVhrBirthdate() {
    return vhrBirthdate;
  }

  public void setVhrBirthdate(Date vhrBirthdate) {
    this.vhrBirthdate = vhrBirthdate;
  }

  public String getVhrDeptName() {
    return vhrDeptName;
  }

  public void setVhrDeptName(String vhrDeptName) {
    this.vhrDeptName = vhrDeptName;
  }
  @Override
  public String toString() {
  	return "req_oc_isdn_ex{"+
     "reqOcIsdnExId :" + reqOcIsdnExId + ","+
     "reqOcId :" + reqOcId + ","+
     "reqOcIsdnId :" + reqOcIsdnId + ","+
     "ocIsdn :" + ocIsdn + ","+
     "isdnEx :" + isdnEx + ","+
     "customerId :" + customerId + ","+
     "cusName :" + cusName + ","+
     "idNo :" + idNo + ","+
     "idIssueDate :" + idIssueDate + ","+
     "idIssuePlace :" + idIssuePlace + ","+
     "status :" + status + ","+
     "type :" + type + ","+
     "address :" + address + ","+
     "vhrIdNo :" + vhrIdNo + ","+
     "vhrName :" + vhrName + ","+
     "vhrBirthdate :" + vhrBirthdate + ","+
     "vhrDeptName :" + vhrDeptName + ","+
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
public ReqOcIsdnEx toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
