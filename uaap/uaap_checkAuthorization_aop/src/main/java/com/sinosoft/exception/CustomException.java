package com.sinosoft.exception;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1379911103434628081L;

	private int code;

	private String message = "";

	public CustomException(int code, String message) {
		super("[" + code + "]" + message);
		this.code = code;
		this.message = message;
	}

	public CustomException(int code) {
		super(HttpStatus.valueOf(code).getReasonPhraseCN());
		HttpStatus httpStatus = HttpStatus.valueOf(code);
		this.code = code;
		this.message = httpStatus.getReasonPhraseCN();
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
