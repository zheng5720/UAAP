package com.sinosoft.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinosoft.common.CheckConfig;

@Component
public class InitResourceListJob {

	
	@Scheduled(cron="${uaap.checkAuthorization.initJobTime}")
	public void initJob() {
		System.out.println("eeeee");
	}
}
