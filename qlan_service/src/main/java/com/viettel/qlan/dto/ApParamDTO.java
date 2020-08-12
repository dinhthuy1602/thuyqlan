package com.viettel.qlan.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.ApParam;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "AP_PARAMBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApParamDTO extends QlanBaseDTO<ApParam>{

	@AdjHistory(field="AP_PARAM_ID")
  private Long apParamId;
	@AdjHistory(field="CODE")
  private String code;
	@AdjHistory(field="TYPE")
  private String type;
	@AdjHistory(field="NAME")
  private String name;
	@AdjHistory(field="VALUE")
  private String value;
	@AdjHistory(field="STATUS")
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
public ApParam toModel() {
	// TODO Auto-generated method stub
	return null;
}

}
