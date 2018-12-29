package com.example.service.JobQuartz;

import com.example.constant.Constant;
import com.example.mapper.quartz.JobConfigMapper;
import com.example.pojo.Result;
import com.example.pojo.quartz.JobConfig;
import com.example.quartz.runner.QuartzManager;
import com.example.util.comm.ResultComm;
import com.example.util.quartz.JobConfigeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobConfigServiceImpl implements JobConfigService {
	@Autowired
	private JobConfigMapper jobConfigMapper;

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Override
	public List<JobConfig> getJobsByStatus(String statusID) {
		return jobConfigMapper.getJobsByStatus(statusID);
	}

	@Override
	public JobConfig getJobsByID(String ID) {
		return jobConfigMapper.getJobsByPrimaryKey(ID);
	}

	@Override
	public void mdfBreakTime(String ID, Date breakTime) {
		jobConfigMapper.updateLastTime(ID, breakTime);
	}

	/**
	 * @Author:CBL
	 * @Description: 禁用定时任务
	 * @params:[taskID]
	 * @return: void
	 * @Date: 2018/7/28 9:26
	 */
	@Override
	public Result mdfDisableTask(String taskID) throws Exception {
		//修改任务状态
		jobConfigMapper.updateStatusByID(taskID, Constant.JOB_STATUS_PAUSE);
		//移除任务
		JobConfig jobConfig = jobConfigMapper.getJobsByPrimaryKey(taskID);
		QuartzManager.removeJob(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getFullEntity(), jobConfig.getGroupName());
		return ResultComm.success();
	}


	/**
	 * @Author:CBL
	 * @Description: 启动定时任务
	 * @params:[taskID]
	 * @return: com.zmqy.util.pojo.Result
	 * @Date: 2018/7/28 9:56
	 */
	@Override
	public Result mdfUserTask(String taskID, Class taskClass) throws Exception {
		//修改任务状态
		jobConfigMapper.updateStatusByID(taskID, Constant.JOB_STATUS_COM);
		//添加任务
		JobConfig jobConfig = jobConfigMapper.getJobsByPrimaryKey(taskID);
		if (jobConfig.getCronTime() == null) {
			QuartzManager.addJob(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getCronTime(), taskClass);
		}
		return ResultComm.success();
	}

	/**
	 * @Author:CBL
	 * @Description: 修改定时任务表达式
	 * @params:[taskID, taskName, cron, taskClass]
	 * @return: com.zmqy.util.pojo.Result
	 * @Date: 2018/7/28 10:04
	 */
	@Override
	public Result mdfUpdateTask(String taskID, String taskName, String cron, Class taskClass, String thirdID) throws Exception {
		JobConfig jobConfig = jobConfigMapper.getJobsByPrimaryKey(taskID);
		if (jobConfig == null) {
			// 添加定时任务记录
			jobConfig = JobConfigeUtil.createJobConfigeUtil(taskID, cron, taskName, taskClass.getName(), Constant.JOB_STATUS_COM, thirdID);
			jobConfigMapper.insert(jobConfig);
			QuartzManager.addJob(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getFullEntity(), jobConfig.getGroupName(), cron, taskClass);
		} else {
			jobConfigMapper.updateCronByID(taskID, cron);
			//修改定时任务
			QuartzManager.mdfJobTime(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName(), cron);
		}
		return ResultComm.success();

	}

	@Override
	public Result exeOneJobConfig(String jobConfigID) throws Exception {
		JobConfig jobConfig = jobConfigMapper.getJobsByPrimaryKey(jobConfigID);

		QuartzManager.doJob(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName());

		return ResultComm.success();
	}

	@Override
	public Result mdfOneJobConfig(String jobConfigID, String cronTime) throws Exception {
		JobConfig oldJobConfig = jobConfigMapper.getJobsByPrimaryKey(jobConfigID);

		if (oldJobConfig == null) {
			return ResultComm.error(Constant.JSON_STATUS_COTHERERR, "无此任务");
		}

		JobConfig newJobConfig = jobConfigMapper.getJobsByPrimaryKey(jobConfigID);

		newJobConfig.setCronTime(cronTime);

		jobConfigMapper.updateCronTime(newJobConfig.getID(), newJobConfig.getCronTime());

		QuartzManager.mdfJobTime(schedulerFactoryBean, newJobConfig.getFullEntity(), newJobConfig.getGroupName(), newJobConfig.getCronTime());

		return ResultComm.success();
	}

	@Override
	public Result pauseOneJobConfig(String jobConfigID) throws Exception {
		JobConfig jobConfig = jobConfigMapper.getJobsByPrimaryKey(jobConfigID);

		if (jobConfig == null) {
			return ResultComm.error(Constant.JSON_STATUS_COTHERERR, "无此任务");
		}

		QuartzManager.removeJob(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getFullEntity(), jobConfig.getGroupName());

		jobConfigMapper.updateStatus(jobConfigID, Constant.JOB_STATUS_PAUSE);

		return ResultComm.success();
	}

	@Override
	public Result startOneJobConfig(String jobConfigID) throws Exception {
		JobConfig jobConfig = jobConfigMapper.getJobsByPrimaryKey(jobConfigID);

		if (jobConfig == null) {
			return ResultComm.error(Constant.JSON_STATUS_COTHERERR, "无此任务");
		}

		QuartzManager.addJob(schedulerFactoryBean, jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getFullEntity(), jobConfig.getGroupName(), jobConfig.getCronTime(), Class.forName(jobConfig.getFullEntity()));

		jobConfigMapper.updateStatus(jobConfigID, Constant.JOB_STATUS_COM);

		return ResultComm.success();
	}

	@Override
	public Result getJobConfigByThirdID(String thirdID) {
		return ResultComm.success(jobConfigMapper.getJobConfigByThirdID(thirdID));
	}


}
