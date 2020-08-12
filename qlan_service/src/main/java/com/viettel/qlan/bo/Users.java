package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.qlan.dto.UsersDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */


@Table(name="users")
@Entity
public class Users extends BaseFWModelImpl{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "USER_ID")
  private Long userId;
  @Column(name= "USER_NAME")
  private String userName;
  @Column(name= "FULL_NAME")
  private String fullName;
  @Column(name= "PASSWORD")
  private String password;
  @Column(name= "EMAIL")
  private String email;
  @Column(name= "DEPT_ID")
  private Long deptId;
  @Column(name= "STATUS")
  private Long status;
  @Column(name= "TE_FAX")
  private String teFax;
  @Column(name= "GENDER")
  private Long gender;
  @Column(name= "BIRTH_PLACE")
  private String birthPlace;
  @Column(name= "IDENTITY_CARD")
  private String identityCard;
  @Column(name= "ISSUE_PLACE_IDENT")
  private String issuePlaceIdent;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "ISSUE_DATE_IDENT")
  private Date issueDateIdent;
  @Column(name= "DESCRIPTION")
  private String description;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "VALID_FROM")
  private Date validFrom;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "VALID_TO")
  private Date validTo;
  @Column(name= "CHECK_IP")
  private Long checkIp;
  @Column(name= "IP")
  private String ip;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "LAST_CHANGE_PASSWORD")
  private Date lastChangePassword;
  @Column(name= "CREATE_USER")
  private String createUser;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "CREATE_DATE")
  private Date createDate;
  @Column(name= "LOGIN_FAILURE_COUNT")
  private Long loginFailureCount;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name= "LAST_LOCK_DATE")
  private Date lastLockDate;
  @Column(name= "DATE_OF_BIRTH")
	private Date dateOfBirth;
	  
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
     "createUser :" + createUser + ","+
     "createDate :" + createDate + ","+
     "loginFailureCount :" + loginFailureCount + ","+
     "lastLockDate :" + lastLockDate + ","+
   "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Users that = (Users) o;
    return java.util.Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode(){
  	return java.util.Objects.hash(userId);
  }

@Override
public UsersDTO toDTO() {
	
	UsersDTO users= new UsersDTO();
	users.setBirthPlace(birthPlace);
	users.setCheckIp(checkIp);
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
	users.setStatus(status);
	users.setTeFax(teFax);
	users.setUserId(userId);
	users.setUserName(userName);
	users.setValidFrom(validFrom);
	users.setValidTo(validTo);
	users.setDateOfBirth(dateOfBirth);
	return users;
}
}
