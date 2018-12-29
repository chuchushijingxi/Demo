package com.Demo.controller.quartz;

import com.Demo.pojo.Result;
import com.Demo.service.JobQuartz.JobConfigService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/quartz/jobConfig")
public class JobConfigController {
	@Autowired
	private JobConfigService service;

	/**
	 * 根据任务类型查询任务
	 *
	 * @param third
	 * @return
	 */

	@PostMapping("/getJobConfigByThirdID")
	public Result getJobConfigByThirdID(@RequestBody Map<String, String> map) {
		return service.getJobConfigByThirdID(map.get("thirdID"));
	}


	/**
	 * 开始任务
	 *
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/startOneJobConfig")
	public Result startOneJobConfig(@RequestBody Map<String, String> map) throws Exception {
		return service.startOneJobConfig(map.get("id"));
	}

	/**
	 * 暂停任务
	 *
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/pauseOneJobConfig")
	public Result pauseOneJobConfig(@RequestBody Map<String, String> map) throws Exception {
		return service.pauseOneJobConfig(map.get("id"));
	}

	/**
	 * 立即执行任务
	 *
	 * @param json
	 * @return
	 * @throws SchedulerException
	 */
	@PostMapping("/exeOneJobConfig")
	public Result exeOneJobConfig(@RequestBody Map<String, String> map) throws Exception {
		return service.exeOneJobConfig(map.get("id"));
	}

	/**
	 * 修改任务
	 *
	 * @param jobConfig
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/mdfOneJobConfig")
	public Result mdfOneJobConfig(@RequestBody Map<String, String> map) throws Exception {
		return service.mdfOneJobConfig(map.get("id"), map.get("cronTime"));
	}
}
