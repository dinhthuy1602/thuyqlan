package com.viettel.qlan.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.viettel.base.common.AdjHistory;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.collect.Lists;
import com.viettel.qlan.bo.Area;

/**
 * @generated automatic by GenDTO.groovy
 * @Author: HaVD
 */

@XmlRootElement(name = "AREABO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaDTO extends QlanBaseDTO<Area> {
	@AdjHistory(field = "ID")
	private Long id;
	private Long idCheck;

	public Long getIdCheck() {
		return idCheck;
	}

	public void setIdCheck(Long idCheck) {
		this.idCheck = idCheck;
	}

	@AdjHistory(field = "PARENT_ID")
	private Long parentId;
	@AdjHistory(field = "AREA_CODE")
	private String areaCode;
	@AdjHistory(field = "AREA_NAME")
	private String areaName;
	@AdjHistory(field = "STATUS")
	private Long status;
	@AdjHistory(field = "PATH")
	private String path;

	private String name;
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String parentName;

	private List<AreaDTO> lstList;

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
	public String toString() {
		return "area{" + "id :" + id + "," + "parentId :" + parentId + "," + "areaCode :" + areaCode + ","
				+ "areaName :" + areaName + "," + "status :" + status + "," + "path :" + path + "," + "}";
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<AreaDTO> getLstList() {
		return lstList;
	}

	public void setLstList(List<AreaDTO> lstList) {
		this.lstList = lstList;
	}

	@Override
	public Area toModel() {
		Area area = new Area();
		area.setId( this.id );
		area.setAreaCode( this.areaCode );
		area.setAreaName( this.areaName );
		area.setParentId( this.parentId );
		area.setPath( this.path );
		area.setStatus( this.status );
		return area;
	}

}
