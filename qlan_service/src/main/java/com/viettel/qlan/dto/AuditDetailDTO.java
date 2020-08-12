package com.viettel.qlan.dto;

import java.util.*;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.AuditDetail;
import com.viettel.qlan.utils.JsonDateDeserializer;
import com.viettel.qlan.utils.JsonDateSerializerDate;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class AuditDetailDTO extends QlanBaseDTO<AuditDetail>{

  private Long id;

  private Long auditId;

  @JsonSerialize(using = JsonDateSerializerDate.class)
  @JsonDeserialize(using = JsonDateDeserializer.class)
  private Date createDate;

  private String colName;

  private String oldValue;

  private String newValue;

  private Long objectId;

  private String tableName;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAuditId() {
    return auditId;
  }

  public void setAuditId(Long auditId) {
    this.auditId = auditId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getColName() {
    return colName;
  }

  public void setColName(String colName) {
    this.colName = colName;
  }

  public String getOldValue() {
    return oldValue;
  }

  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }

  public String getNewValue() {
    return newValue;
  }

  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }
  @Override
  public String toString() {
  	return "audit_detail{"+
     "id :" + id + ","+
     "auditId :" + auditId + ","+
     "createDate :" + createDate + ","+
     "colName :" + colName + ","+
     "oldValue :" + oldValue + ","+
     "newValue :" + newValue + ","+
     "objectId :" + objectId + ","+
     "tableName :" + tableName + ","+
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
public AuditDetail toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
