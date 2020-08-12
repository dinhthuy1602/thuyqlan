package com.viettel.qlan.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.viettel.base.common.AdjHistory;
import com.viettel.qlan.bo.StaffCbv;
import com.viettel.qlan.utils.CustomJsonDateDeserializer;
import com.viettel.qlan.utils.CustomJsonDateSerializer;
/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "STAFFCBVBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffCbvDTO extends QlanBaseDTO<StaffCbv>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AdjHistory(field="STAFF_ID")
  private Long staffId;
	@AdjHistory(field="STAFF_CODE")
  private String staffCode;
	@AdjHistory(field="NAME")
  private String name;
	@AdjHistory(field="TEL")
  private String tel;
	@AdjHistory(field="TEL2")
  private String tel2;
	@AdjHistory(field="DEPT_CODE")
  private String deptCode;
	@AdjHistory(field="STATUS")
  private Long status;
	@AdjHistory(field="ID_NO")
  private String idNo;
	@AdjHistory(field="LEVEL")
  private Long level;
  private String levelName;
  private List<ExcelDTO> lstError;
  private String filePathError;
  private String reqCode;
  private String isdn;
  private String deptName;
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  private Date reqDateFrom;
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  private Date reqDateTo;
  @JsonDeserialize(using = CustomJsonDateDeserializer.class)
  @JsonSerialize(using = CustomJsonDateSerializer.class)
  private Date reqDate;
  private Long reqOcId;
  private boolean initBCA;
  private Long countSuccess;
  public boolean isInitBCA() {
	return initBCA;
}

public void setInitBCA(boolean initBCA) {
	this.initBCA = initBCA;
}

public Date getReqDateFrom() {
	return reqDateFrom;
}

public void setReqDateFrom(Date reqDateFrom) {
	this.reqDateFrom = reqDateFrom;
}

public Date getReqDateTo() {
	return reqDateTo;
}

public void setReqDateTo(Date reqDateTo) {
	this.reqDateTo = reqDateTo;
}


public StaffCbvDTO() {
}

  public StaffCbvDTO(Long staffId, String staffCode, String name, String tel, String email, String tel2, Long status, String deptCode,String idNo) {
    this.staffId = staffId;
    this.staffCode = staffCode;
    this.name = name;
    this.tel = tel;
    this.tel2 = tel2;
    this.deptCode = deptCode;
    this.status = status;
    this.idNo = idNo;
  }

  public Long getStaffId() {
    return staffId;
  }

  public void setStaffId(Long staffId) {
    this.staffId = staffId;
  }

  public String getStaffCode() {
    return staffCode;
  }

  public void setStaffCode(String staffCode) {
    this.staffCode = staffCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }


  public String getTel2() {
	return tel2;
}

public void setTel2(String tel2) {
	this.tel2 = tel2;
}

public String getDeptCode() {
	return deptCode;
}

public void setDeptCode(String deptCode) {
	this.deptCode = deptCode;
}

public String getIdNo() {
	return idNo;
}

public void setIdNo(String idNo) {
	this.idNo = idNo;
}

public Long getLevel() {
	return level;
}

public void setLevel(Long level) {
	this.level = level;
}

public String getLevelName() {
	return levelName;
}

public void setLevelName(String levelName) {
	this.levelName = levelName;
}

public List<ExcelDTO> getLstError() {
	return lstError;
}

public void setLstError(List<ExcelDTO> lstError) {
	this.lstError = lstError;
}

public String getFilePathError() {
	return filePathError;
}

public void setFilePathError(String filePathError) {
	this.filePathError = filePathError;
}

public String getReqCode() {
	return reqCode;
}

public void setReqCode(String reqCode) {
	this.reqCode = reqCode;
}

public String getIsdn() {
	return isdn;
}

public void setIsdn(String isdn) {
	this.isdn = isdn;
}

public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public Date getReqDate() {
	return reqDate;
}

public void setReqDate(Date reqDate) {
	this.reqDate = reqDate;
}

public Long getReqOcId() {
	return reqOcId;
}

public void setReqOcId(Long reqOcId) {
	this.reqOcId = reqOcId;
}

public Long getCountSuccess() {
	return countSuccess;
}

public void setCountSuccess(Long countSuccess) {
	this.countSuccess = countSuccess;
}

@Override
public String toString() {
	   return "user_alerts{"+
	     "staffId :" + staffId + ","+
	     "staffCode :" + staffCode + ","+
	     "name :" + name + ","+
	     "tel :" + tel + ","+
	     "tel2 :" + tel2 + ","+
	     "deptCode :" + deptCode + ","+
	     "idNo :" + idNo + ","+
	     "status :" + status + ","+
	   "}";
	  }


@Override
public String catchName() {
	// TODO Auto-generated method stub
	return staffId.toString();
}

@Override
public Long getFWModelId() {
	return staffId;
}

@Override
public StaffCbv toModel() {
	StaffCbv u = new StaffCbv();
	u.setStaffId(this.staffId);
	u.setStaffCode(this.staffCode);
	u.setStatus(this.status);
	u.setDeptCode(this.deptCode);
	u.setTel(this.tel);
	u.setName(this.name);
	u.setTel2(this.tel2);
	u.setIdNo(this.idNo);
	u.setLevel(this.level);
	return u;
}

}
