package com.sinosoft.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sinosoft.common.CheckConfig;
import com.sinosoft.exception.CustomException;
import com.sinosoft.service.ICheckAuthorizationService;
import com.sinosoft.service.ICheckIsLoginService;

@Aspect
@Component
public class CheckAuthorization {

	@Autowired
	private ICheckIsLoginService checkIsLoginService;
	
	@Autowired
	private ICheckAuthorizationService checkAuthor;
//	
	@Autowired
	private CheckConfig config;
//	
//	@Pointcut("execution(public * *(..) && @annotation(org.springframework.web.bind.annotation.RequestMapping))")
//	public void checkUserAuthor() {
//		
//	}
//	
//	@Before("checkUserAuthor()")
//	public void doBefor(Joinpoint joinPoint) throws Exception {
//		boolean isLoading = false;
//		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		String url = request.getServletPath();
//		List<String> list = config.getExclusionurl();
//		if(!list.contains(url)) {
//			isLoading = checkIsLoginService.isLogin(request);
//			if(!isLoading) {
//				throw new CustomException(100601);
//			} else {
//				if(!checkAuthor.checkAuthorization(request)) {
//					throw new CustomException(100602);
//				}
//			}
//		}
//	}
//	
	@Pointcut("execution(public * *(..)) &&  @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void checkAuthorization() {

	}

	@Before("checkAuthorization()")
	public void before() throws Exception {
		boolean isLoading = false;
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String url = request.getServletPath();
		List<String> list = config.getExclusionurl();
		if(!list.contains(url)) {
			isLoading = checkIsLoginService.isLogin(request);
			if(!isLoading) {
				throw new CustomException(100601);
			} else {
				if(!checkAuthor.checkAuthorization(request)) {
					throw new CustomException(100602);
				}
			}
		}
	}
}
