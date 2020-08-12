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


@Table(name="req_oc_isdn_ex")
@Entity
public class ReqOcIsdnEx extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "REQ_OC_ISDN_EX_ID")
  private Long reqOcIsdnExId;
  @Column(name= "REQ_OC_ID")
  private Long reqOcId;
  @Column(name= "REQ_OC_ISDN_ID")
  private Long reqOcIsdnId;
  @Column(name= "OC_ISDN")
  private String ocIsdn;
  @Column(name= "ISDN_EX")
  private String isdnEx;
  @Column(name= "CUSTOMER_ID")
  private Long customerId;
  @Column(name= "CUS_NAME")
  private String cusName;
  @Column(name= "ID_NO")
  private String idNo;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "ID_ISSUE_DATE")
  private Date idIssueDate;
  @Column(name= "ID_ISSUE_PLACE")
  private String idIssuePlace;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "TYPE")
  private String type;
  @Column(name= "ADDRESS")
  private String address;
  @Column(name= "VHR_ID_NO")
  private String vhrIdNo;
  @Column(name= "VHR_NAME")
  private String vhrName;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "VHR_BIRTHDATE")
  private Date vhrBirthdate;
  @Column(name= "VHR_DEPT_NAME")
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReqOcIsdnEx that = (ReqOcIsdnEx) o;
    return java.util.Objects.equals(reqOcIsdnExId, that.reqOcIsdnExId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(reqOcIsdnExId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
