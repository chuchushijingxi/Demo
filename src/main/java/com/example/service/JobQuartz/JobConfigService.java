package com.example.service.JobQuartz;


import com.example.pojo.Result;
import com.example.pojo.quartz.JobConfig;

import java.util.Date;
import java.util.List;

public interface JobConfigService {
	List<JobConfig> getJobsByStatus(String statusID);

	JobConfig getJobsByID(String ID);

	void mdfBreakTime(String ID, Date breakTime);

	Result mdfDisableTask(String taskId) throws Exception;

	Result mdfUserTask(String taskID, Class taskClass) throws Exception;

	Result mdfUpdateTask(String taskID, String taskName, String cron, Class taskClass, String thirdID) throws Exception;

	Result exeOneJobConfig(String id) throws Exception;

	Result mdfOneJobConfig(String id, String cronTime) throws Exception;

	Result pauseOneJobConfig(String id) throws Exception;

	Result startOneJobConfig(String id) throws Exception;

	Result getJobConfigByThirdID(String thirdID);
}
