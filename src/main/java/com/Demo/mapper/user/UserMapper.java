package com.Demo.mapper.user;

import com.Demo.pojo.example.Example;
import com.Demo.pojo.user.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
	int countByExample(Example example);

	int deleteByExample(Example example);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(Example example);

	User selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") Example example);

	int updateByExample(@Param("record") User record, @Param("example") Example example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByUserName(String name);

	User selectByUserNameAndPassword(@Param("name") String name, @Param("password") String password);
}