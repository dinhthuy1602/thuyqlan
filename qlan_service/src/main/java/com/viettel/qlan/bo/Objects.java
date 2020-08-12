package com.viettel.qlan.bo;

import com.viettel.qlan.dto.ObjectsDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import javax.persistence.*;
import java.util.*;

/**
 * @generated automatic by KyPOJO_model.groovy
 * @Author: kyph
 */


@Table(name="objects")
@Entity
public class Objects extends BaseFWModelImpl{

	 public Objects() {
	        setColId("objectId");
	        setColName("objectId");
	        setUniqueColumn(new String[]{"objectId"});
	}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "OBJECT_ID")
  private Long objectId;
  @Column(name= "PARENT_ID")
  private Long parentId;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "ORD")
  private Long ord;
  @Column(name= "OBJECT_URL")
  private String objectUrl;
  @Column(name= "OBJECT_NAME")
  private String objectName;
  @Column(name= "DESCRIPTION")
  private String description;
  @Column(name= "OBJECT_TYPE_ID")
  private Long objectTypeId;
  @Column(name= "OBJECT_CODE")
  private String objectCode;
  @Column(name= "CREATE_USER")
  private String createUser;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;


  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public Long getOrd() {
    return ord;
  }

  public void setOrd(Long ord) {
    this.ord = ord;
  }

  public String getObjectUrl() {
    return objectUrl;
  }

  public void setObjectUrl(String objectUrl) {
    this.objectUrl = objectUrl;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getObjectTypeId() {
    return objectTypeId;
  }

  public void setObjectTypeId(Long objectTypeId) {
    this.objectTypeId = objectTypeId;
  }

  public String getObjectCode() {
    return objectCode;
  }

  public void setObjectCode(String objectCode) {
    this.objectCode = objectCode;
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
 
  public ObjectsDTO toDTO(){
    ObjectsDTO objDTO = new ObjectsDTO();
    objDTO.setObjectId(this.getObjectId());
    objDTO.setObjectCode(this.getObjectCode());
    objDTO.setObjectName(this.getObjectName());
    objDTO.setStatus(this.getStatus());
    objDTO.setParentId(this.getParentId());
    objDTO.setOrd(this.getOrd());
    objDTO.setObjectUrl(this.getObjectUrl());
    objDTO.setDescription(this.getDescription());
    objDTO.setObjectTypeId(this.getObjectTypeId());
    objDTO.setCreateDate(this.getCreateDate());
    objDTO.setCreateUser(this.getCreateUser());
    return  objDTO;
  }
}
