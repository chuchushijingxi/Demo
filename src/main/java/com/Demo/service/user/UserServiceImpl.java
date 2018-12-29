package com.Demo.service.user;

import com.Demo.config.jwt.JwtConfig;
import com.Demo.config.redis.MyJedisPool;
import com.Demo.constant.Constant;
import com.Demo.mapper.user.UserMapper;
import com.Demo.pojo.Result;
import com.Demo.pojo.user.User;
import com.Demo.util.comm.ResultComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-14 17:48
 **/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Result login(Map<String, String> paramsMap, HttpServletRequest request) throws Exception {
		String userName = paramsMap.get("userName");

		String password = paramsMap.get("password");

		User user = userMapper.selectByUserName(userName);
		if (user != null) {
			User verificationUser = userMapper.selectByUserNameAndPassword(userName, password);

			if (verificationUser != null) {

				if (Constant.NORMAL.equals(verificationUser.getStatus())) {
					verificationUser.setLastLoginTime(new Date());

					userMapper.updateByPrimaryKeySelective(verificationUser);

					String token;
					try {
						token = JwtConfig.createToken(verificationUser.getId());
					} catch (Exception e) {
						throw new RuntimeException("token创建错误");
					}

					Map<String, Object> resultMap = new HashMap<>();
					resultMap.put("userName", verificationUser);
					resultMap.put("token", token);

					//放入redis
					Integer id = verificationUser.getId();
					//ip绑定
					/*String remoteAddr = request.getRemoteAddr();
					String md5Key = EncryptUtil.Md5(remoteAddr + id);*/

					//redis存储token
					/*Jedis jedis = MyJedisPool.getJedisObject();
					jedis.set(id + "", token);
					MyJedisPool.recycleJedisOjbect(jedis);*/

					return ResultComm.success(resultMap);
				} else {
					return ResultComm.error("用户已被禁用");
				}
			} else {
				return ResultComm.error("用户密码不正确");
			}
		} else {
			return ResultComm.error("该用户不存在");
		}
	}

	@Override
	public Result register(User user) {

		String name = user.getName();
		String password = user.getPassword();

		if (StringUtils.isEmpty(name)) {
			return ResultComm.error("用户名不能为空");
		}

		if (StringUtils.isEmpty(password)) {
			return ResultComm.error("密码不能为空");
		}

		User u = userMapper.selectByUserName(name);
		if (u == null) {
			userMapper.insert(u);
			return ResultComm.success();
		} else {
			return ResultComm.error("该用户名已存在");
		}
	}

	@Override
	public Result getOut(Map<String, String> paramsMap) {
		String id = paramsMap.get("id");

		Jedis jedis = MyJedisPool.getJedisObject();

		jedis.set(id, "");

		return ResultComm.success();
	}
}
