package com.sinosoft.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="uaap.checkauthorization")
public class CheckConfig {

	//系统名称
	private String appId="";
	
	//判断登录方式
	private String checkISLoginType="0";
	
	//SESSION或者redis的key值
	private String keyName="loginUser";
	
	//用URL方式判断是否登录的地址
	private String url="";
	
	//第三方实现自定义方法
	private String customClass="";
	
	public final static String CUSTOM_TYPE="0";
	
	public final static String URL_TYPE="1";
	
	public final static String SESSION_TYPE="2";
	
	private List<String> exclusionurl = new ArrayList<String>();

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getCheckISLoginType() {
		return checkISLoginType;
	}

	public void setCheckISLoginType(String checkISLoginType) {
		this.checkISLoginType = checkISLoginType;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCustomClass() {
		return customClass;
	}

	public void setCustomClass(String customClass) {
		this.customClass = customClass;
	}

	public List<String> getExclusionurl() {
		return exclusionurl;
	}

	public void setExclusionurl(List<String> exclusionurl) {
		this.exclusionurl = exclusionurl;
	}
	
}
