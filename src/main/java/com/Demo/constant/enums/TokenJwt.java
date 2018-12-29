package com.Demo.constant.enums;

/**
 * @program: myself
 * @description:
 * @author: zlf
 * @create: 2018-12-25 16:01
 **/
public enum TokenJwt {

	TOKEN_FORMAT_ERROR("token格式错误", 114),
	TOKEN_VERIFICATION_ERROR("token验证非法异常", 115),
	TOKEN_EXPIRED_ERROR("token过期", 499),
	TOKEN_NOT_FOUND("用户验证失败", 116);


	private String msg;
	private Integer code;

	TokenJwt(String msg, Integer code) {
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
