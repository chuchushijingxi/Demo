package com.example.pojo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
	private Integer id;

	private String name;

	private String sex;

	private Integer age;

	private Date lastLoginTime;

	private String password;

	private String status;

	private static final long serialVersionUID = 1L;


}