package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="audit_detail")
@Entity
public class AuditDetail extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "ID")
  private Long id;
  @Column(name= "AUDIT_ID")
  private Long auditId;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;
  @Column(name= "COL_NAME")
  private String colName;
  @Column(name= "OLD_VALUE")
  private String oldValue;
  @Column(name= "NEW_VALUE")
  private String newValue;
  @Column(name= "OBJECT_ID")
  private Long objectId;
  @Column(name= "TABLE_NAME")
  private String tableName;

  public AuditDetail() {
      setColId("id");
      setColName("id");
      setUniqueColumn(new String[]{"id"});
}

  public AuditDetail(Long auditId, String colName, String oldValue, String newValue, Long objectId, String tableName) {
    this.auditId = auditId;
    this.createDate = Calendar.getInstance().getTime();
    this.colName = colName;
    this.oldValue = oldValue;
    this.newValue = newValue;
    this.objectId = objectId;
    this.tableName = tableName;
  }

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
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
