package com.sushank.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sushank.demo.model.User;

public interface UserMapper
{
	/*@SelectKey(statement="call identity()", keyProperty="id",
		    before=false, resultType=Integer.class)*/
	@Insert("insert into users(name,email) values(#{name},#{email})")
    void insertUser(User user);
    @Select("select id, name, email from users WHERE id=#{id}")
    User findUserById(Integer id);
    /*@Select("select id, name, email from users")*/
    List<User> findAllUsers();
}
