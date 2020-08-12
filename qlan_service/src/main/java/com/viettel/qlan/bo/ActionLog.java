package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="action_log")
@Entity
public class ActionLog extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "LOG_ID")
  private Long logId;
  @Column(name= "ACTION_CODE")
  private String actionCode;
  @Column(name= "USER_CODE")
  private String userCode;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "ACTION_TIME")
  private Date actionTime;
  @Column(name= "CONTENT")
  private String content;


  public Long getLogId() {
    return logId;
  }

  public void setLogId(Long logId) {
    this.logId = logId;
  }

  public String getActionCode() {
    return actionCode;
  }

  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public Date getActionTime() {
    return actionTime;
  }

  public void setActionTime(Date actionTime) {
    this.actionTime = actionTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  
@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
