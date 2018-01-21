package com.example.demo.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Integer errorCode;
	
	private String errorMsg;
	
	public ErrorDTO(Integer errorCode, String errorMsg)
	{
		super();
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
	}
	
	public ErrorDTO()
	{
		super();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
