package com.Demo.constant.enums.table;

public enum UserTable {

	id("id"),
	name("name"),
	sex("sex"),
	age("age"),
	lastLoginTime("lastLoginTime"),
	password("password"),
	status("status");

	private String column;

	UserTable(String column) {
		this.column = column;
	}

	public String getColumn() {
		return column;
	}
}
