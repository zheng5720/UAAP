package com.sinosoft.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnMessage {

	private String message = "";
	
	private String url = "";
	
	private String timestamp= "";
	
	private int code;
}
