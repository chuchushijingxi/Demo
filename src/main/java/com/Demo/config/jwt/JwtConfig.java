package com.Demo.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.Demo.constant.enums.TokenJwt;
import com.Demo.pojo.jwt.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-25 14:16
 **/
@Component
public class JwtConfig {

	@Autowired
	private Audience audience;

	public static JwtConfig jwtConfig;

	@PostConstruct
	public void init() {
		jwtConfig = this;
	}

	/**
	 * JWT生成Token
	 * JWT构成: header, payload, signature
	 *
	 * @param user_id 登录成功后用户user_id, 参数user_id不可传空
	 */
	public static String createToken(Integer user_id) throws Exception {
		Date iatDate = new Date();
		Date expires = new Date(iatDate.getTime() + jwtConfig.audience.getTime());

		// header Map
		Map<String, Object> map = new HashMap<>();
		map.put("alg", "HS256");
		map.put("typ", "JWT");

		String token = JWT.create().withHeader(map) // header
				.withClaim("iss", jwtConfig.audience.getIss()) // payload
				.withClaim("sub", jwtConfig.audience.getSub()).withClaim("user_id", null == user_id ? null : user_id.toString())
				.withIssuedAt(iatDate) // sign time
				.withExpiresAt(expires) // expire time
				.sign(Algorithm.HMAC256(jwtConfig.audience.getBase64Secret())); // signature
		return token;
	}

	/**
	 * 解密Token
	 *
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Claim> verifyToken(String token) {
		DecodedJWT jwt;
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtConfig.audience.getBase64Secret())).build();
			jwt = verifier.verify(token);
		} catch (Exception e) {
			// e.printStackTrace();
			// token 校验失败, 抛出Token验证非法异常
			throw new RuntimeException(TokenJwt.TOKEN_VERIFICATION_ERROR.getMsg());
		}
		return jwt.getClaims();
	}

	/**
	 * 根据Token获取user_id
	 *
	 * @param token
	 * @return user_id
	 */
	public static Long getAppUID(String token) {
		Map<String, Claim> claims = verifyToken(token);
		Claim user_id_claim = claims.get("user_id");
		if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
			// token 校验失败, 抛出Token验证非法异常
		}
		return Long.valueOf(user_id_claim.asString());
	}

	public static void main(String[] args) throws Exception {
		String token = createToken(7);
		System.out.println(token);
		System.out.println(getAppUID(token));
		System.out.println(verifyToken(token));

	}
}
