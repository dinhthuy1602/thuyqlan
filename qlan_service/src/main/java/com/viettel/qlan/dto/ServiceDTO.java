package com.viettel.qlan.dto;

import com.viettel.qlan.bo.Service;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */


public class ServiceDTO extends QlanBaseDTO<Service>{

  private Long serviceId;

  private Long telecomServiceId;

  private String serviceName;

  private String description;

  private String prepaid;

  private Long status;


  public Long getServiceId() {
    return serviceId;
  }

  public void setServiceId(Long serviceId) {
    this.serviceId = serviceId;
  }

  public Long getTelecomServiceId() {
    return telecomServiceId;
  }

  public void setTelecomServiceId(Long telecomServiceId) {
    this.telecomServiceId = telecomServiceId;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrepaid() {
    return prepaid;
  }

  public void setPrepaid(String prepaid) {
    this.prepaid = prepaid;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }
  @Override
  public String toString() {
  	return "service{"+
     "serviceId :" + serviceId + ","+
     "telecomServiceId :" + telecomServiceId + ","+
     "serviceName :" + serviceName + ","+
     "description :" + description + ","+
     "prepaid :" + prepaid + ","+
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
public Service toModel() {
	// TODO Auto-generated method stub
	return null;
}


}
