package com.viettel.qlan.bo;

import javax.persistence.*;

import com.viettel.qlan.dto.DeptDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */

@Table(name = "dept")
@Entity
public class Dept extends BaseFWModelImpl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPT_ID")
	private Long deptId;
	@Column(name = "DEPT_NAME")
	private String deptName;
	@Column(name = "PARENT_DEPT_ID")
	private Long parentDeptId;
	@Column(name = "STATUS")
	private Long status;
	@Column(name = "DEPT_CODE")
	private String deptCode;

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

	@Override
	public BaseFWDTOImpl toDTO() {
		DeptDTO deptDto = new DeptDTO();
		deptDto.setDeptCode(this.deptCode);
		deptDto.setDeptId(this.deptId);
		deptDto.setDeptName(this.deptName);
		deptDto.setParentDeptId(this.parentDeptId);
		deptDto.setStatus(this.status);
		return deptDto;
	}
}
