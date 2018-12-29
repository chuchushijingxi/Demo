package com.example.pojo.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: CBL
 * @Description: JWT参数
 * @Date: Created in 15:08 2018/4/12
 */
@Data
@ConfigurationProperties("audience")
@Component
public class Audience {
	/**
	 * wt所面向的用户
	 */
	private String sub;
	/**
	 * 密钥
	 */
	private String base64Secret;
	/**
	 * 签发者
	 */
	private String iss;
	/**
	 * 过期时长
	 */
	private int time;
	/**
	 * 失效时长
	 */
	private int expiresSecond;

}
