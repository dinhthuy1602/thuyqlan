package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="assign_req_oc")
@Entity
public class AssignReqOc extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "ID")
  private Long id;
  @Column(name= "REQ_OC_ID")
  private Long reqOcId;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "ASSIGN_DATE")
  private Date assignDate;
  @Column(name= "USER_ASSIGN")
  private String userAssign;
  @Column(name= "USER_RECEIVED")
  private String userReceived;
  @Column(name= "STATUS")
  private Long status;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getReqOcId() {
    return reqOcId;
  }

  public void setReqOcId(Long reqOcId) {
    this.reqOcId = reqOcId;
  }

  public Date getAssignDate() {
    return assignDate;
  }

  public void setAssignDate(Date assignDate) {
    this.assignDate = assignDate;
  }

  public String getUserAssign() {
    return userAssign;
  }

  public void setUserAssign(String userAssign) {
    this.userAssign = userAssign;
  }

  public String getUserReceived() {
    return userReceived;
  }

  public void setUserReceived(String userReceived) {
    this.userReceived = userReceived;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
