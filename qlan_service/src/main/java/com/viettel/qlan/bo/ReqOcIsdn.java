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


@Table(name="req_oc_isdn")
@Entity
public class ReqOcIsdn extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "REQ_OC_ISDN_ID")
  private Long reqOcIsdnId;
  @Column(name= "REQ_OC_ID")
  private Long reqOcId;
  @Column(name= "ISDN")
  private String isdn;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CHECK_FROM_DATE")
  private Date checkFromDate;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CHECK_TO_DATE")
  private Date checkToDate;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "FILE_RESULT")
  private String fileResult;


  public Long getReqOcIsdnId() {
    return reqOcIsdnId;
  }

  public void setReqOcIsdnId(Long reqOcIsdnId) {
    this.reqOcIsdnId = reqOcIsdnId;
  }

  public Long getReqOcId() {
    return reqOcId;
  }

  public void setReqOcId(Long reqOcId) {
    this.reqOcId = reqOcId;
  }

  public String getIsdn() {
    return isdn;
  }

  public void setIsdn(String isdn) {
    this.isdn = isdn;
  }

  public Date getCheckFromDate() {
    return checkFromDate;
  }

  public void setCheckFromDate(Date checkFromDate) {
    this.checkFromDate = checkFromDate;
  }

  public Date getCheckToDate() {
    return checkToDate;
  }

  public void setCheckToDate(Date checkToDate) {
    this.checkToDate = checkToDate;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public String getFileResult() {
    return fileResult;
  }

  public void setFileResult(String fileResult) {
    this.fileResult = fileResult;
  }
  @Override
  public String toString() {
   return "req_oc_isdn{"+
     "reqOcIsdnId :" + reqOcIsdnId + ","+
     "reqOcId :" + reqOcId + ","+
     "isdn :" + isdn + ","+
     "checkFromDate :" + checkFromDate + ","+
     "checkToDate :" + checkToDate + ","+
     "status :" + status + ","+
     "fileResult :" + fileResult + ","+
   "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ReqOcIsdn that = (ReqOcIsdn) o;
    return java.util.Objects.equals(reqOcIsdnId, that.reqOcIsdnId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(reqOcIsdnId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
