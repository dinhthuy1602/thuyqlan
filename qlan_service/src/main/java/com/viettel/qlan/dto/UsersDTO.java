package com.viettel.qlan.dto;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.Users;
import com.viettel.qlan.utils.CustomJsonDateDeserializer;
import com.viettel.qlan.utils.CustomJsonDateSerializer;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersDTO extends QlanBaseDTO<Users>{
	@AdjHistory(field="USER_ID")
  private Long userId;
  @AdjHistory(field="USER_NAME")
  private String userName;
  @AdjHistory(field="FULL_NAME")
  private String fullName;
  @AdjHistory(field="PASSWORD")
  private String password;
  @AdjHistory(field="EMAIL")
  private String email;
  @AdjHistory(field="DEPT_ID")
  private Long deptId;
  @AdjHistory(field="STATUS")
  private Long status;
  @AdjHistory(field="TE_FAX")
  private String teFax;
  @AdjHistory(field="GENDER")
  private Long gender;
  @AdjHistory(field="BIRTH_PLACE")
  private String birthPlace;
  @AdjHistory(field="IDENTITY_CARD")
  private String identityCard;
  @AdjHistory(field="ISSUE_PLACE_IDENT")
  private String issuePlaceIdent;

  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  @AdjHistory(field="DATE_OF_BIRTH")
  private Date dateOfBirth;

@JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  @AdjHistory(field="ISSUE_DATE_IDENT")
  private Date issueDateIdent;
  @AdjHistory(field="DESCRIPTION")
  private String description;

  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  @AdjHistory(field="VALID_FROM")
  private Date validFrom;

  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  @AdjHistory(field="VALID_TO")
  private Date validTo;
  @AdjHistory(field="CHECK_IP")
  private Long checkIp;
  @AdjHistory(field="IP")
  private String ip;

  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  private Date lastChangePassword;

  private Long column20;

  private String createUser;

  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  private Date createDate;

  private Long loginFailureCount;

  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  private Date lastLockDate;

  private List<ObjectsDTO> listObject=Lists.newArrayList();
  private List<RoleUserDTO> listRole=Lists.newArrayList();
  
  public List<RoleUserDTO> getListRole() {
	return listRole;
}

public void setListRole(List<RoleUserDTO> listRole) {
	this.listRole = listRole;
}

private boolean lock;
  
  private String deptName;
  
  public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public boolean isLock() {
	return lock;
}

public void setLock(boolean lock) {
	this.lock = lock;
}

public List<ObjectsDTO> getListObject() {
	return listObject;
 }

public void setListObject(List<ObjectsDTO> listObject) {
	this.listObject = listObject;
}

public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public String getTeFax() {
    return teFax;
  }

  public void setTeFax(String teFax) {
    this.teFax = teFax;
  }

  public Long getGender() {
    return gender;
  }

  public void setGender(Long gender) {
    this.gender = gender;
  }

  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public String getIdentityCard() {
    return identityCard;
  }

  public void setIdentityCard(String identityCard) {
    this.identityCard = identityCard;
  }

  public String getIssuePlaceIdent() {
    return issuePlaceIdent;
  }

  public void setIssuePlaceIdent(String issuePlaceIdent) {
    this.issuePlaceIdent = issuePlaceIdent;
  }

  public Date getIssueDateIdent() {
    return issueDateIdent;
  }

  public void setIssueDateIdent(Date issueDateIdent) {
    this.issueDateIdent = issueDateIdent;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public Long getCheckIp() {
    return checkIp;
  }

  public void setCheckIp(Long checkIp) {
    this.checkIp = checkIp;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Date getLastChangePassword() {
    return lastChangePassword;
  }

  public void setLastChangePassword(Date lastChangePassword) {
    this.lastChangePassword = lastChangePassword;
  }

  public Long getColumn20() {
    return column20;
  }

  public void setColumn20(Long column20) {
    this.column20 = column20;
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

  public Long getLoginFailureCount() {
    return loginFailureCount;
  }

  public void setLoginFailureCount(Long loginFailureCount) {
    this.loginFailureCount = loginFailureCount;
  }

  public Date getLastLockDate() {
    return lastLockDate;
  }

  public void setLastLockDate(Date lastLockDate) {
    this.lastLockDate = lastLockDate;
  }

  public Date getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
  @Override
  public String toString() {
  	return "users{"+
     "userId :" + userId + ","+
     "userName :" + userName + ","+
     "fullName :" + fullName + ","+
     "password :" + password + ","+
     "email :" + email + ","+
     "deptId :" + deptId + ","+
     "status :" + status + ","+
     "teFax :" + teFax + ","+
     "gender :" + gender + ","+
     "birthPlace :" + birthPlace + ","+
     "identityCard :" + identityCard + ","+
     "issuePlaceIdent :" + issuePlaceIdent + ","+
     "issueDateIdent :" + issueDateIdent + ","+
     "description :" + description + ","+
     "validFrom :" + validFrom + ","+
     "validTo :" + validTo + ","+
     "checkIp :" + checkIp + ","+
     "ip :" + ip + ","+
     "lastChangePassword :" + lastChangePassword + ","+
     "column20 :" + column20 + ","+
     "createUser :" + createUser + ","+
     "createDate :" + createDate + ","+
     "loginFailureCount :" + loginFailureCount + ","+
     "lastLockDate :" + lastLockDate + ","+
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
public Users toModel() {
	Users users= new Users();
	users.setBirthPlace(birthPlace);
	users.setCheckIp(checkIp !=null ? checkIp:0l);
	users.setCreateDate(createDate);
	users.setCreateUser(createUser);
	users.setDeptId(deptId);
	users.setDescription(description);
	users.setEmail(email);
	users.setFullName(fullName);
	users.setGender(gender);
	users.setIdentityCard(identityCard);
	users.setIp(ip);
	users.setIssueDateIdent(issueDateIdent);
	users.setIssuePlaceIdent(issuePlaceIdent);
	users.setLastChangePassword(lastChangePassword);
	users.setLastLockDate(lastLockDate);
	users.setLoginFailureCount(loginFailureCount);
	users.setPassword(password);
	users.setStatus(status!=null?status:1l);
	users.setTeFax(teFax);
	users.setUserId(userId);
	users.setUserName(userName);
	users.setValidFrom(validFrom);
	users.setValidTo(validTo);
	users.setDateOfBirth(dateOfBirth);
	return users;
}


}
