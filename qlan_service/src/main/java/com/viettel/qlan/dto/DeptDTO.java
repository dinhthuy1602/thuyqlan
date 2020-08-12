package com.viettel.qlan.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.viettel.qlan.bo.Dept;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "DEPTBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeptDTO extends QlanBaseDTO<Dept> {

	private Long deptId;

	private String deptName;

	private Long parentDeptId;

	private Long status;

	private String deptCode;

	private String parentDeptName;

	private List<DeptDTO> lstList;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(Long parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getParentDeptName() {
		return parentDeptName;
	}

	public void setParentDeptName(String parentDeptName) {
		this.parentDeptName = parentDeptName;
	}

	public List<DeptDTO> getLstList() {
		return lstList;
	}

	public void setLstList(List<DeptDTO> lstList) {
		this.lstList = lstList;
	}

	@Override
	public String toString() {
		return "dept{" + "deptId :" + deptId + "," + "deptName :" + deptName + "," + "parentDeptId :" + parentDeptId
				+ "," + "status :" + status + "," + "deptCode :" + deptCode + "," + "}";
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
	public Dept toModel() {
		Dept dept = new Dept();
		dept.setDeptCode(this.deptCode);
		dept.setDeptId(this.deptId);
		dept.setDeptName(this.deptName);
		dept.setParentDeptId(this.parentDeptId);
		dept.setStatus(this.status);
		return dept;
	}

}
