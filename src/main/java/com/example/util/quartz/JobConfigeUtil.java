package com.example.util.quartz;


import com.example.constant.Constant;
import com.example.pojo.quartz.JobConfig;

import java.util.Date;

/**
 * @author: CBL
 * @description:
 * @Date: 2018-07-26 10:04
 */
public class JobConfigeUtil {

	/**
	 * @Author:CBL
	 * @Description: 创建爱你表达式实体类
	 * @params:[id, cronTime, name, entity, third, statusId, thirdID]
	 * @return: com.zmqy.pojo.o2o.quartz.JobConfig
	 * @Date: 2018/7/26 10:19
	 */
	public static JobConfig createJobConfigeUtil(String id, String cronTime, String name, String entity, String statusId, String thirdID) {
		Date date = new Date();
		JobConfig jobConfig = new JobConfig();
		jobConfig.setID(id);
		jobConfig.setCreateUser(Constant.JOB_CREATER);
		jobConfig.setCronTime(cronTime);
		jobConfig.setDesc(name);
		jobConfig.setFullEntity(entity);
		jobConfig.setGroupName(Constant.GROUP_NAME);
		jobConfig.setStatusID(statusId);
		jobConfig.setName(name);
		jobConfig.setThirdID(thirdID);
		jobConfig.setCreateTime(date);
		jobConfig.setLastNumber(Long.valueOf(0));
		jobConfig.setLastTime(date);
		jobConfig.setLastUpdateTime(date);
		return jobConfig;
	}
}
