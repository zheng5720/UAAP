package com.sinosoft.exception;

import lombok.Getter;

@Getter
public enum HttpStatus {

	NO_LOGIN(100601,"用户未登录！","no login"),
	
	NO_AUTHORIZATION(100602,"用户没有该权限","user no authorization");
	
	private final int code;
	
	private final String reasonPhraseCN;
	
	private final String reasonPhraseEN;
	
	HttpStatus(int code,String reasonPhraseCN,String reasonPhraseEN){
		this.code = code;
		this.reasonPhraseCN = reasonPhraseCN;
		this.reasonPhraseEN=reasonPhraseEN;
	}
	
	public static HttpStatus valueOf(int code) {
		for(HttpStatus status:values()) {
			if(status.code == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("No matching constant for[" + code + "]");
	}
}
