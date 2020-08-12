package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.LogValidate;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class LogValidateDTO extends QlanBaseDTO<LogValidate>{

  private Long logId;

  private Long reqOcId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date createDate;

  public Long getLogId() {
    return logId;
  }

  public void setLogId(Long logId) {
    this.logId = logId;
  }
  public Long getReqOcId() {
    return reqOcId;
  }

  public void setReqOcId(Long reqOcId) {
    this.reqOcId = reqOcId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  @Override
  public String toString() {
  	return "log_validate{"+
     "reqOcId :" + reqOcId + ","+
     "createDate :" + createDate + ","+
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
public LogValidate toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
