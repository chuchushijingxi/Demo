package com.Demo.controller.index;

import com.Demo.pojo.Result;
import com.Demo.pojo.user.User;
import com.Demo.service.user.UserService;
import com.Demo.util.comm.ResultComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-14 17:45
 **/
@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public Result login(@RequestBody Map<String, String> paramsMap, HttpServletRequest request) throws Exception {
		return userService.login(paramsMap, request);
	}

	@RequestMapping("/register")
	@ResponseBody
	public Result register(@RequestBody User user) {
		return userService.register(user);
	}

	/**
	 * @Description: 踢出用户
	 * @params:
	 * @Author: zlf
	 * @Date: 2018-12-25
	 */
	@RequestMapping("/getOut")
	@ResponseBody
	public Result getOut(@RequestBody Map<String, String> paramsMap) {
		return userService.getOut(paramsMap);
	}

	@RequestMapping("/test1")
	@ResponseBody
	public Result test1() {
		return ResultComm.success();
	}

	@RequestMapping("/test2")
	public String test2() throws Exception {
		return "login";
	}
}
