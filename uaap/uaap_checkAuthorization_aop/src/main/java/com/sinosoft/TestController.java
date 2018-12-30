package com.sinosoft;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.common.AuthUser;

@RestController
@RequestMapping("user")
public class TestController {
	
	@Value("${uaap.checkauthorization.keyName}")
	private String keyName = "loginUser";
	
	@RequestMapping("/loginUser")
	public AuthUser loginUser(HttpSession session, @RequestParam("userId") String userId,
			@RequestParam("deptId") String deptId) {
		AuthUser authUser = new AuthUser();
		authUser.setUserId(userId);
		authUser.setDeptId(deptId);
		String authToken = UUID.randomUUID().toString().replace("-","");
		authUser.setAuthToken(authToken);
		session.setAttribute(keyName, authUser);
		return authUser;
	}
	
	@RequestMapping("/isLogin")
	public AuthUser isLogin(HttpSession session) {
		AuthUser authUser = (AuthUser)session.getAttribute(keyName);
		if(null == authUser) {
			authUser = new AuthUser();
		}
		return authUser;
	}
	
	@RequestMapping("/getLoginUser")
	public AuthUser getLoginUser(HttpSession session) {
		AuthUser authUser = (AuthUser)session.getAttribute(keyName);
		if(null == authUser) {
			authUser = new AuthUser();
		}
		return authUser;
	}
	
	@RequestMapping("/signOut")
	public AuthUser signOut(HttpSession session) {
		session.invalidate();
		return null;
	}
}
