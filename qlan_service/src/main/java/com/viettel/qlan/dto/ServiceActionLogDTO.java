package com.viettel.qlan.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.ServiceActionLog;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class ServiceActionLogDTO extends QlanBaseDTO<ServiceActionLog>{

  private Long actionLogId;

  private String actionName;

  private String actionUrl;

  private String param;

  private String ip;

  private String createUser;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date createDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date startTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private Date endTime;


  public Long getActionLogId() {
    return actionLogId;
  }

  public void setActionLogId(Long actionLogId) {
    this.actionLogId = actionLogId;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getActionUrl() {
    return actionUrl;
  }

  public void setActionUrl(String actionUrl) {
    this.actionUrl = actionUrl;
  }

  public String getParam() {
    return param;
  }

  public void setParam(String param) {
    this.param = param;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
  @Override
  public String toString() {
  	return "service_action_log{"+
     "actionLogId :" + actionLogId + ","+
     "actionName :" + actionName + ","+
     "actionUrl :" + actionUrl + ","+
     "param :" + param + ","+
     "ip :" + ip + ","+
     "createUser :" + createUser + ","+
     "createDate :" + createDate + ","+
     "startTime :" + startTime + ","+
     "endTime :" + endTime + ","+
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
public ServiceActionLog toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
