package com.viettel.qlan.dto;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.ActionAudit;
import com.viettel.qlan.utils.JsonDateDeserializer;
import com.viettel.qlan.utils.JsonDateSerializerDate;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "ACTION_AUDITBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionAuditDTO extends QlanBaseDTO<ActionAudit>{

  private Long auditId;

  private Long auditTypeId;

  private Long objectId;

  private String objectType;

  @JsonSerialize(using = JsonDateSerializerDate.class)
  @JsonDeserialize(using = JsonDateDeserializer.class)
  private Date createDate;

  private String description;

  private String userName;

  private String serverIp;


  public Long getAuditId() {
    return auditId;
  }

  public void setAuditId(Long auditId) {
    this.auditId = auditId;
  }

  public Long getAuditTypeId() {
    return auditTypeId;
  }

  public void setAuditTypeId(Long auditTypeId) {
    this.auditTypeId = auditTypeId;
  }

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }
  @Override
  public String toString() {
  	return "action_audit{"+
     "auditId :" + auditId + ","+
     "auditTypeId :" + auditTypeId + ","+
     "objectId :" + objectId + ","+
     "objectType :" + objectType + ","+
     "createDate :" + createDate + ","+
     "description :" + description + ","+
     "userName :" + userName + ","+
     "serverIp :" + serverIp + ","+
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
public ActionAudit toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
