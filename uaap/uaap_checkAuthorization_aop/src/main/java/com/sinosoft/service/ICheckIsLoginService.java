package com.sinosoft.service;

import javax.servlet.http.HttpServletRequest;

public interface ICheckIsLoginService {

	public boolean isLogin(HttpServletRequest request);
}
