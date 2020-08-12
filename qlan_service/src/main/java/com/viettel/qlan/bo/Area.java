package com.viettel.qlan.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.viettel.qlan.dto.AreaDTO;
import com.viettel.service.base.model.BaseFWModelImpl;

/**
 * @generated automatic by GenModel.groovy
 * @Author: HaVD
 */

@Table(name = "area")
@Entity
public class Area extends BaseFWModelImpl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "PARENT_ID")
	private Long parentId;
	@Column(name = "AREA_CODE")
	private String areaCode;
	@Column(name = "AREA_NAME")
	private String areaName;
	@Column(name = "STATUS")
	private Long status;
	@Column(name = "PATH")
	private String path;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public AreaDTO toDTO() {
		AreaDTO areaDTO = new AreaDTO();
		areaDTO.setId(this.id);
		areaDTO.setAreaCode(this.areaCode);
		areaDTO.setAreaName(this.areaName);
		areaDTO.setParentId(this.parentId);
		areaDTO.setPath(this.path);
		areaDTO.setStatus(this.status);
		return areaDTO;
	}
}
