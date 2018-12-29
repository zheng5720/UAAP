package com.sinosoft;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

	@RequestMapping("/json")
	public String json() throws Exception {
		throw new Exception("发生错误2");
	}
	
	@RequestMapping("/isLogin")
	public String isLogin() throws Exception {
		throw new Exception("发生错误3");
	}

}
