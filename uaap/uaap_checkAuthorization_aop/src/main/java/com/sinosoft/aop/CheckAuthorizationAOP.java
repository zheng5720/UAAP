package com.sinosoft.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sinosoft.common.CheckConfig;
import com.sinosoft.service.ICheckAuthorizationService;
import com.sinosoft.service.ICheckIsLoginService;

@Aspect
@Component
@Order(-1)
public class CheckAuthorizationAOP {

	@Autowired
	private ICheckIsLoginService checkIsLoginService;
	
	@Autowired
	private ICheckAuthorizationService checkAuthor;
	
	@Autowired
	private CheckConfig config;
	
	@Pointcut("execution(public * *(..) && @annotation(org.springframework.web.bind.annotation.RequestMapping))")
	public void checkUserAuthor() {
		
	}
	
	@Before("checkUserAuthor()")
	public void doBefor(Joinpoint joinPoint) throws Exception {
		boolean isLoading = false;
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String url = request.getServletPath();
		List<String> list = null;//config.
		if(!list.contains(url)) {
			isLoading = checkIsLoginService.isLogin(request);
			if(!isLoading) {
				throw new Exception("未正常登录！");
			} else {
				if(!checkAuthor.checkAuthorization(request)) {
					throw new Exception("用户没有查看权限！");
				}
			}
		}
	}
}
