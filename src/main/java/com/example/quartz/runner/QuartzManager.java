package com.example.quartz.runner;

import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 定时任务管理
 * @author anson
 *
 */
public class QuartzManager {
	
	/**
	 * 立即执行任务
	 * @param schedulerFactoryBean
	 * @param name
	 * @param groupName
	 * @throws SchedulerException
	 */
	public static void doJob(SchedulerFactoryBean schedulerFactoryBean, String jobName, String jobGroupName) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
		
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		
		scheduler.triggerJob(jobKey);
	}
	
	 /**
	  * 添加一个定时任务
	  * @param schedulerFactoryBean
	  * @param name
	  * @param group
	  * @param description
	  * @param cronExpression
	  * @param jobClazz
	  * @throws Exception
	  */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addJob(SchedulerFactoryBean schedulerFactoryBean,
								   String jobName, String jobGroupName,
								   String triggerName, String triggerGroupName,
								   String cronExpression, Class jobClazz) throws Exception {

		JobDetail jobDetail= JobBuilder.newJob(jobClazz).withIdentity(jobName, jobGroupName).build();

		// 触发器
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		// 触发器名,触发器组
		triggerBuilder.withIdentity(triggerName, triggerGroupName);
		triggerBuilder.startNow();
		// 触发器时间设定
		triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
		// 创建Trigger对象
		CronTrigger trigger = (CronTrigger) triggerBuilder.build();

		// 调度容器设置JobDetail和Trigger
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		scheduler.scheduleJob(jobDetail, trigger);

		// 启动
		if (!scheduler.isShutdown()) {
			scheduler.start();
		}
	}
	
	/**
	 * 修改一个任务的触发时间
	 * @param schedulerFactoryBean
	 * @param triggerName
	 * @param triggerGroupName
	 * @param cronExpression
	 * @throws SchedulerException
	 */
	public static void mdfJobTime(SchedulerFactoryBean schedulerFactoryBean,
			String triggerName, String triggerGroupName,
			String cronExpression) throws SchedulerException {
		
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		
		TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);  
        if (trigger == null) {  
            return;  
        }  
        
        String oldTime = trigger.getCronExpression(); 
        
        if (!oldTime.equalsIgnoreCase(cronExpression)) { 
            /** 方式一 ：调用 rescheduleJob 开始 */
            // 触发器  
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组  
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // 触发器时间设定  
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
            // 创建Trigger对象
            trigger = (CronTrigger) triggerBuilder.build();
            // 方式一 ：修改一个任务的触发时间
            scheduler.rescheduleJob(triggerKey, trigger);
            /** 方式一 ：调用 rescheduleJob 结束 */

            /** 方式二：先删除，然后在创建一个新的Job  */
            //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));  
            //Class<? extends Job> jobClass = jobDetail.getJobClass();  
            //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);  
            //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron); 
            /** 方式二 ：先删除，然后在创建一个新的Job */
        }  
	}
	
	/**
	 * 移除一个任务
	 * @param schedulerFactoryBean
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @throws SchedulerException
	 */
	public static void removeJob(SchedulerFactoryBean schedulerFactoryBean,
			String jobName, String jobGroupName,  
			String triggerName, String triggerGroupName) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		
		TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
		
		scheduler.pauseTrigger(triggerKey);// 停止触发器  
		scheduler.unscheduleJob(triggerKey);// 移除触发器  
		scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
	}
	
	/**
	 * 启动所有的任务
	 * @param schedulerFactoryBean
	 * @throws SchedulerException
	 */
	public static void startJobs(SchedulerFactoryBean schedulerFactoryBean) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		
		scheduler.start();
	}
	
	public static void shutdowJobs(SchedulerFactoryBean schedulerFactoryBean) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		
		scheduler.shutdown();
	}
}
