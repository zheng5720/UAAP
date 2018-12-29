package com.sinosoft.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sinosoft.service.ICheckIsLoginService;

@Service
public class CheckIsLoginServiceImpl implements ICheckIsLoginService {

	@Override
	public boolean isLogin(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
