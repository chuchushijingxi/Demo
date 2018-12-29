package com.Demo.controller;

import com.Demo.pojo.Result;
import com.Demo.util.comm.ResultComm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-29 15:18
 **/
@RequestMapping("/noToken")
@RestController
public class TestController {


	@RequestMapping("/test")
	public Result test() {
		return ResultComm.success();
	}
}
