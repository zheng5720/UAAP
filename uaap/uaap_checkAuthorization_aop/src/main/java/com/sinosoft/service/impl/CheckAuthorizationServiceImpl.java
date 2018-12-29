package com.sinosoft.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sinosoft.service.ICheckAuthorizationService;

@Service
public class CheckAuthorizationServiceImpl implements ICheckAuthorizationService {

	@Override
	public boolean checkAuthorization(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
