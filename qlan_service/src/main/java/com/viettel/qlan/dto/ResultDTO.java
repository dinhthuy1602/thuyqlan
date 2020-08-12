package com.viettel.qlan.dto;

public class ResultDTO {
private String message;
private Integer errorCode;
private Object data;
private boolean isError=false;
public boolean isError() {
	return isError;
}
public void setError(boolean isError) {
	this.isError = isError;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getErrorCode() {
	return errorCode;
}
public void setErrorCode(Integer errorCode) {
	this.errorCode = errorCode;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
} 
}
