package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="ap_param")
@Entity
public class ApParam extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "AP_PARAM_ID")
  private Long apParamId;
  @Column(name= "CODE")
  private String code;
  @Column(name= "TYPE")
  private String type;
  @Column(name= "NAME")
  private String name;
  @Column(name= "VALUE")
  private String value;
  @Column(name= "STATUS")
  private Long status;


  public Long getApParamId() {
    return apParamId;
  }

  public void setApParamId(Long apParamId) {
    this.apParamId = apParamId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }
  @Override
  public String toString() {
   return "ap_param{"+
     "apParamId :" + apParamId + ","+
     "code :" + code + ","+
     "type :" + type + ","+
     "name :" + name + ","+
     "value :" + value + ","+
     "status :" + status + ","+
   "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ApParam that = (ApParam) o;
    return java.util.Objects.equals(apParamId, that.apParamId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(apParamId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
