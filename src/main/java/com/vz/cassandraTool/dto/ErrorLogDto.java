package com.vz.cassandraTool.dto;

public class ErrorLogDto {
	private String errorCode;
	private String errorName;
	private String type;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	} public ErrorLogDto() {
		// TODO Auto-generated constructor stub
	}
	public ErrorLogDto(String errorCode, String errorName, String type) {
		super();
		this.errorCode = errorCode;
		this.errorName = errorName;
		this.type = type;
	}
}
