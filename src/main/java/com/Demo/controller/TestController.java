package com.Demo.controller;

import com.Demo.constant.enums.table.UserTable;
import com.Demo.mapper.user.UserMapper;
import com.Demo.pojo.Result;
import com.Demo.pojo.example.Example;
import com.Demo.pojo.user.User;
import com.Demo.util.comm.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-29 15:18
 **/
@RequestMapping("/noToken")
@RestController
public class TestController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/test")
	public Result test() {
		Example example = new Example();
		example.createCriteria().andEqualTo(UserTable.id.getColumn(), 1);
		List<User> users = userMapper.selectByExample(example);
		return ResultUtil.success(users);
	}
}
