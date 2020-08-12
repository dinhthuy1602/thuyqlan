package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="service")
@Entity
public class Service extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "SERVICE_ID")
  private Long serviceId;
  @Column(name= "TELECOM_SERVICE_ID")
  private Long telecomServiceId;
  @Column(name= "SERVICE_NAME")
  private String serviceName;
  @Column(name= "DESCRIPTION")
  private String description;
  @Column(name= "PREPAID")
  private String prepaid;
  @Column(name= "STATUS")
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Service that = (Service) o;
    return java.util.Objects.equals(serviceId, that.serviceId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(serviceId);
  }

@Override
public BaseFWDTOImpl toDTO() {
	// TODO Auto-generated method stub
	return null;
}
}
