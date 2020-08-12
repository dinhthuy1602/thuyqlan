package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.ReqOcIsdn;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class ReqOcIsdnDTO extends QlanBaseDTO<ReqOcIsdn>{

  private Long reqOcIsdnId;

  private Long reqOcId;

  private String isdn;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date checkFromDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date checkToDate;

  private Long status;

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
public ReqOcIsdn toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
