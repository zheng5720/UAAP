package com.sinosoft.service;

import javax.servlet.http.HttpServletRequest;

public interface ICheckAuthorizationService {

	public boolean checkAuthorization(HttpServletRequest request);
}
