package com.sinosoft.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sinosoft.common.AuthUser;
import com.sinosoft.service.ICheckIsLoginService;

@Service
public class CheckIsLoginServiceImpl implements ICheckIsLoginService {

	@Value("${uaap.checkauthorization.keyName}")
	private String keyName = "loginUser";
	
	@Override
	public boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthUser authUser = (AuthUser)session.getAttribute(keyName);
		if(null == authUser || "".equals(authUser.getAuthToken())) {
			return false;
		}
		return true;
	}

}
