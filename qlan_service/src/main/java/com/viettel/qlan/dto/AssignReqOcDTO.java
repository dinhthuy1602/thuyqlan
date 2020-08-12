package com.viettel.qlan.dto;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.viettel.qlan.bo.AssignReqOc;
import com.viettel.qlan.utils.JsonDateDeserializer;
import com.viettel.qlan.utils.JsonDateSerializerDate;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "AssignReqOCBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignReqOcDTO extends QlanBaseDTO<AssignReqOc>{

  private Long id;

  private Long reqOcId;

  @JsonSerialize(using = JsonDateSerializerDate.class)
  @JsonDeserialize(using = JsonDateDeserializer.class)
  private Date assignDate;

  private String userAssign;

  private String userReceived;

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
  public String toString() {
  	return "assign_req_oc{"+
     "id :" + id + ","+
     "reqOcId :" + reqOcId + ","+
     "assignDate :" + assignDate + ","+
     "userAssign :" + userAssign + ","+
     "userReceived :" + userReceived + ","+
     "status :" + status + ","+
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
public AssignReqOc toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
