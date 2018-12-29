package com.example.quartz.runner;


import com.example.constant.Constant;
import com.example.pojo.quartz.JobConfig;
import com.example.service.JobQuartz.JobConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuartzRunner implements CommandLineRunner {
	@Autowired
	private JobConfigService jobConfigservice;

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Override
	public void run(String... arg0) throws Exception {
		List<JobConfig> JobConfigList = jobConfigservice.getJobsByStatus(Constant.JOB_STATUS_COM);

		for (JobConfig jobConfig : JobConfigList) {
			if (!"".equals(jobConfig.getCronTime())) {
				QuartzManager.addJob(schedulerFactoryBean,
						jobConfig.getFullEntity(), jobConfig.getGroupName(),
						jobConfig.getFullEntity(), jobConfig.getGroupName(),
						jobConfig.getCronTime(), Class.forName(jobConfig.getFullEntity()));
			}
		}
	}

}
