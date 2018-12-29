package com.example.mapper.quartz;

import com.example.pojo.quartz.JobConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface JobConfigMapper {
	List<JobConfig> getJobsByStatus(String statusID);

	JobConfig getJobsByPrimaryKey(String ID);

	List<JobConfig> getJobConfigByThirdID(String thirdID);

	void updateLastTime(@Param("ID") String ID, @Param("lastTime") Date lastTime);

	void updateStatus(@Param("ID") String ID, @Param("statusID") String statusID);

	void updateCronTime(@Param("ID") String ID, @Param("cronTime") String cronTime);

	void insert(JobConfig jobConfig);

	void updateStatusByID(@Param("id") String id, @Param("statusID") String statusID);

	void updateCronByID(@Param("id") String id, @Param("cronTime") String cronTime);
}
