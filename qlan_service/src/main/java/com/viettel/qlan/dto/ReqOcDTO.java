package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.ReqOc;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class ReqOcDTO extends QlanBaseDTO<ReqOc>{

  private Long reqOcId;

  private String code;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date reqDate;

  private String ocFile;

  private String listIsdnFile;

  private String resultFile;

  private Long status;

  private String userUpdate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date updateDateTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date endTimeProcess;

  private Long statusSmsCbv;

  private Long statusSmsVt;

  private Long statusSmsVtex;

  private Long type;

  private String fromArea;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date inputDate;

  private String compendium;

  private String note;

  private String areaCode;


  public Long getReqOcId() {
    return reqOcId;
  }

  public void setReqOcId(Long reqOcId) {
    this.reqOcId = reqOcId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Date getReqDate() {
    return reqDate;
  }

  public void setReqDate(Date reqDate) {
    this.reqDate = reqDate;
  }

  public String getOcFile() {
    return ocFile;
  }

  public void setOcFile(String ocFile) {
    this.ocFile = ocFile;
  }

  public String getListIsdnFile() {
    return listIsdnFile;
  }

  public void setListIsdnFile(String listIsdnFile) {
    this.listIsdnFile = listIsdnFile;
  }

  public String getResultFile() {
    return resultFile;
  }

  public void setResultFile(String resultFile) {
    this.resultFile = resultFile;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public String getUserUpdate() {
    return userUpdate;
  }

  public void setUserUpdate(String userUpdate) {
    this.userUpdate = userUpdate;
  }

  public Date getUpdateDateTime() {
    return updateDateTime;
  }

  public void setUpdateDateTime(Date updateDateTime) {
    this.updateDateTime = updateDateTime;
  }

  public Date getEndTimeProcess() {
    return endTimeProcess;
  }

  public void setEndTimeProcess(Date endTimeProcess) {
    this.endTimeProcess = endTimeProcess;
  }

  public Long getStatusSmsCbv() {
    return statusSmsCbv;
  }

  public void setStatusSmsCbv(Long statusSmsCbv) {
    this.statusSmsCbv = statusSmsCbv;
  }

  public Long getStatusSmsVt() {
    return statusSmsVt;
  }

  public void setStatusSmsVt(Long statusSmsVt) {
    this.statusSmsVt = statusSmsVt;
  }

  public Long getStatusSmsVtex() {
    return statusSmsVtex;
  }

  public void setStatusSmsVtex(Long statusSmsVtex) {
    this.statusSmsVtex = statusSmsVtex;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public String getFromArea() {
    return fromArea;
  }

  public void setFromArea(String fromArea) {
    this.fromArea = fromArea;
  }

  public Date getInputDate() {
    return inputDate;
  }

  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }

  public String getCompendium() {
    return compendium;
  }

  public void setCompendium(String compendium) {
    this.compendium = compendium;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }
  @Override
  public String toString() {
  	return "req_oc{"+
     "reqOcId :" + reqOcId + ","+
     "code :" + code + ","+
     "reqDate :" + reqDate + ","+
     "ocFile :" + ocFile + ","+
     "listIsdnFile :" + listIsdnFile + ","+
     "resultFile :" + resultFile + ","+
     "status :" + status + ","+
     "userUpdate :" + userUpdate + ","+
     "updateDateTime :" + updateDateTime + ","+
     "endTimeProcess :" + endTimeProcess + ","+
     "statusSmsCbv :" + statusSmsCbv + ","+
     "statusSmsVt :" + statusSmsVt + ","+
     "statusSmsVtex :" + statusSmsVtex + ","+
     "type :" + type + ","+
     "fromArea :" + fromArea + ","+
     "inputDate :" + inputDate + ","+
     "compendium :" + compendium + ","+
     "note :" + note + ","+
     "areaCode :" + areaCode + ","+
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
public ReqOc toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
