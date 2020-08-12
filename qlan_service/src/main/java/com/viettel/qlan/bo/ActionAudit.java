package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="action_audit")
@Entity(name="")
public class ActionAudit extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "AUDIT_ID")
  private Long auditId;
  @Column(name= "AUDIT_TYPE_ID")
  private Long auditTypeId;
  @Column(name= "OBJECT_ID")
  private Long objectId;
  @Column(name= "OBJECT_TYPE")
  private String objectType;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;
  @Column(name= "DESCRIPTION")
  private String description;
  @Column(name= "USER_NAME")
  private String userName;
  @Column(name= "SERVER_IP")
  private String serverIp;

  public ActionAudit() {
      setColId("auditId");
      setColName("auditId");
      setUniqueColumn(new String[]{"auditId"});
}

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
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
