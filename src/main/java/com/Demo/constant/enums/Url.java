package com.Demo.constant.enums;

public enum Url {

	/**
	 * 登陆url
	 */
	LOGIN("登陆", "/login"),
	/**
	 * 刷新url
	 */
	REFRESH_TOKEN_URL("刷新", "/token/refresh"),
	/**
	 * 注册url
	 */
	REGISTER("注册", "/register"),

	NOTOKEN("无需token", "/noToken");

	private String urlName;
	private String urlAttribute;

	Url(String urlName, String urlAttribute) {
		this.urlName = urlName;
		this.urlAttribute = urlAttribute;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public String getUrlAttribute() {
		return urlAttribute;
	}

	public void setUrlAttribute(String urlAttribute) {
		this.urlAttribute = urlAttribute;
	}
}
