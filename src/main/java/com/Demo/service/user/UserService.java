package com.Demo.service.user;

import com.Demo.pojo.Result;
import com.Demo.pojo.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-14 17:48
 **/
public interface UserService {

	Result login(Map<String, String> paramsMap, HttpServletRequest request) throws Exception;

	Result register(User user);

	Result getOut(Map<String, String> paramsMap);

}
