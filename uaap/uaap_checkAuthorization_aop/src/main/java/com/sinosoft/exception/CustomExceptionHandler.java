package com.sinosoft.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ReturnMessage jsonErrorHandler(HttpServletRequest req, CustomException e) throws Exception {
		ReturnMessage rm = new ReturnMessage();
		rm.setMessage(e.getMessage());
		rm.setCode(e.getCode());
		rm.setTimestamp(new Date().toString());
		rm.setUrl(req.getRequestURL().toString());
		return rm;
	}

}