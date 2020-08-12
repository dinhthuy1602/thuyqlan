package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="req_oc")
@Entity
public class ReqOc extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "REQ_OC_ID")
  private Long reqOcId;
  @Column(name= "CODE")
  private String code;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "REQ_DATE")
  private Date reqDate;
  @Column(name= "OC_FILE")
  private String ocFile;
  @Column(name= "LIST_ISDN_FILE")
  private String listIsdnFile;
  @Column(name= "RESULT_FILE")
  private String resultFile;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "USER_UPDATE")
  private String userUpdate;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "UPDATE_DATE_TIME")
  private Date updateDateTime;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "END_TIME_PROCESS")
  private Date endTimeProcess;
  @Column(name= "STATUS_SMS_CBV")
  private Long statusSmsCbv;
  @Column(name= "STATUS_SMS_VT")
  private Long statusSmsVt;
  @Column(name= "STATUS_SMS_VTEX")
  private Long statusSmsVtex;
  @Column(name= "TYPE")
  private Long type;
  @Column(name= "FROM_AREA")
  private String fromArea;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "INPUT_DATE")
  private Date inputDate;
  @Column(name= "COMPENDIUM")
  private String compendium;
  @Column(name= "NOTE")
  private String note;
  @Column(name= "AREA_CODE")
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
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
