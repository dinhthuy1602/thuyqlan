package com.viettel.qlan.dto;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.ActionLog;
import com.viettel.qlan.utils.JsonDateDeserializer;
import com.viettel.qlan.utils.JsonDateSerializerDate;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "ACTION_LOGBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionLogDTO extends QlanBaseDTO<ActionLog>{

  private Long logId;

  private String actionCode;

  private String userCode;

  @JsonSerialize(using = JsonDateSerializerDate.class)
  @JsonDeserialize(using = JsonDateDeserializer.class)
  private Date actionTime;

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
  public String toString() {
  	return "action_log{"+
     "logId :" + logId + ","+
     "actionCode :" + actionCode + ","+
     "userCode :" + userCode + ","+
     "actionTime :" + actionTime + ","+
     "content :" + content + ","+
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
public ActionLog toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
