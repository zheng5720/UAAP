package com.sinosoft.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class InitResourceListJob {

	
	@Scheduled(cron="${uaap.checkAuthorization.initJobTime}")
	public void initJob() {
		System.out.println("eeeee");
	}
}
