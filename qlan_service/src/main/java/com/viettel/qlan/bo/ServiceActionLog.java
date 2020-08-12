package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;
import java.util.*;
import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="service_action_log")
@Entity
public class ServiceActionLog extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "ACTION_LOG_ID")
  private Long actionLogId;
  @Column(name= "ACTION_NAME")
  private String actionName;
  @Column(name= "ACTION_URL")
  private String actionUrl;
  @Column(name= "PARAM")
  private String param;
  @Column(name= "IP")
  private String ip;
  @Column(name= "CREATE_USER")
  private String createUser;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "START_TIME")
  private Date startTime;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "END_TIME")
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ServiceActionLog that = (ServiceActionLog) o;
    return java.util.Objects.equals(actionLogId, that.actionLogId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(actionLogId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
