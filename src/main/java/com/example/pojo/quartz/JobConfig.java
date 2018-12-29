package com.example.pojo.quartz;

import lombok.Data;

import java.util.Date;

@Data
public class JobConfig {
	private String ID;
	private String thirdID;
	private String name;
	private String desc;
	private String fullEntity;
	private String groupName;
	private String cronTime;
	private Date lastTime;
	private Long lastNumber;
	private String statusID;
	private Date createTime;
	private String createUser;
	private Date lastUpdateTime;

}
