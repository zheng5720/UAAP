package com.sinosoft.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {

	@Pointcut("execution(public * *(..)) &&  @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void checkAuthorization() {

	}

	@Before("checkAuthorization()")
	public void before() throws Exception {
		throw new Exception("退出异常");
	}
}
