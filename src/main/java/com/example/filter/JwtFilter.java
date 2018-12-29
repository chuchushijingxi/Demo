package com.example.filter;

import com.auth0.jwt.interfaces.Claim;
import com.example.config.jwt.JwtConfig;
import com.example.config.redis.MyJedisPool;
import com.example.constant.enums.TokenJwt;
import com.example.constant.enums.Url;
import com.example.mapper.UserMapper;
import com.example.pojo.Result;
import com.example.pojo.jwt.Audience;
import com.example.pojo.user.User;
import com.example.util.comm.ResultComm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;
import redis.clients.jedis.Jedis;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @program: myself
 * @description: 过滤器, 验证token
 * @author: zlf
 * @create: 2018-12-25 14:24
 **/
@WebFilter("/*")
@Order(2)
@Component
public class JwtFilter extends GenericFilterBean {

	@Autowired
	private Audience audience;
	@Autowired
	private UserMapper userMapper;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		ObjectMapper mapper = new ObjectMapper();
		Result result;

		final HttpServletRequest request = (HttpServletRequest) servletRequest;

		String path = request.getServletPath();

		//String remoteAddr = request.getRemoteAddr();

		if (path.equals(Url.LOGIN.getUrlAttribute()) || path.equals(Url.REFRESH_TOKEN_URL.getUrlAttribute()) || path.equals(Url.REGISTER.getUrlAttribute())) {
			//放行
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		long now = System.currentTimeMillis();

		//取头信息
		final String authHeader = request.getHeader("Authorization");

		//判断是否有bearer为前缀的信息
		if (authHeader == null || !authHeader.startsWith("bearer ")) {
			result = ResultComm.error(TokenJwt.TOKEN_FORMAT_ERROR.getCode(), TokenJwt.TOKEN_FORMAT_ERROR.getMsg());
		} else {
			final String token = authHeader.substring(7);

			//根据token获取用户id
			Integer userID = JwtConfig.getAppUID(token).intValue();

			/*Jedis jedis = MyJedisPool.getJedisObject();
			String userToken = jedis.get(userID + "");*/
			
			User user = userMapper.selectByPrimaryKey(userID);

			if (user != null) {
				//避免为空
				if (audience == null) {
					BeanFactory factory = WebApplicationContextUtils
							.getRequiredWebApplicationContext(request.getServletContext());
					audience = (Audience) factory.getBean("audience");
				}

				Map<String, Claim> stringClaimMap = JwtConfig.verifyToken(token);
				//获取过期时长的Claim
				Claim exp = stringClaimMap.get("exp");

				if (exp.asDate().getTime() < now) {
					result = ResultComm.error(TokenJwt.TOKEN_EXPIRED_ERROR.getCode(), TokenJwt.TOKEN_EXPIRED_ERROR.getMsg());
				} else {
					filterChain.doFilter(servletRequest, servletResponse);
					return;
				}
			} else {
				result = ResultComm.error(TokenJwt.TOKEN_NOT_FOUND.getCode(), TokenJwt.TOKEN_NOT_FOUND.getMsg());
			}
		}
		servletResponse.setCharacterEncoding("utf-8");
		servletResponse.getWriter().write(mapper.writeValueAsString(result));
	}
}
