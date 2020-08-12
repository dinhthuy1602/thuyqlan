package com.viettel.qlan.dto;

import com.viettel.qlan.constant.Constants;
import com.viettel.qlan.utils.QlanResource;

public class ReportDTO {
	private String areaName;
	private String areaCode;
	private Long totalDocumentary;
	private Long totalIsdn;
	private String archivesName;
	private String archivesDate;
	private String inputDate;
	private String compendium;
	private String confidentiality;
	private String typeArchives;
	private String userUpdate;
	private String note;
	private String fromArea;
	private String startDate;
	private String endDate;
	private Long typeReport;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Long getTypeReport() {
		return typeReport;
	}
	public void setTypeReport(Long typeReport) {
		this.typeReport = typeReport;
	}
	public String getArchivesName() {
		return archivesName;
	}
	public void setArchivesName(String archivesName) {
		this.archivesName = archivesName;
	}
	public String getArchivesDate() {
		return archivesDate;
	}
	public void setArchivesDate(String archivesDate) {
		this.archivesDate = archivesDate;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getCompendium() {
		return compendium;
	}
	public void setCompendium(String compendium) {
		this.compendium = compendium;
	}
	public String getConfidentiality() {
		if("1".equals(confidentiality)){
			return QlanResource.get(Constants.KHONGMAT);
		}
		if("2".equals(confidentiality)) {
			return QlanResource.get(Constants.MAT);
		}
		if("3".equals(confidentiality)) {
			return QlanResource.get(Constants.TUYETMAT);
		}
		if("4".equals(confidentiality)) {
			return QlanResource.get(Constants.TOIMAT);
		}
		return confidentiality;
	}
	public void setConfidentiality(String confidentiality) {
		this.confidentiality = confidentiality;
	}
	public String getTypeArchives() {
		return typeArchives;
	}
	public void setTypeArchives(String typeArchives) {
		this.typeArchives = typeArchives;
	}
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getFromArea() {
		return fromArea;
	}
	public void setFromArea(String fromArea) {
		this.fromArea = fromArea;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public Long getTotalDocumentary() {
		return totalDocumentary;
	}
	public void setTotalDocumentary(Long totalDocumentary) {
		this.totalDocumentary = totalDocumentary;
	}
	public Long getTotalIsdn() {
		return totalIsdn;
	}
	public void setTotalIsdn(Long totalIsdn) {
		this.totalIsdn = totalIsdn;
	}
	
	
}
