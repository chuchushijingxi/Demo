package com.example.quartz.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-29 12:02
 **/
@Component
@DisallowConcurrentExecution //当上一个任务未结束时下一个任务需进行等待
public class TestQuartz implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("111");
	}
}
