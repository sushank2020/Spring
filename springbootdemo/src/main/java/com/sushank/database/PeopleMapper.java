package com.sushank.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sushank.demo.model.People;

public interface PeopleMapper {
	
	@Select("select id, firstName,lastName,emailId from people")
	public List<People> findAllPeoples();
	@Insert("insert into people(id, firstName,lastName,emailId) values(#{id},#{firstName},#{lastName},#{emailId})")
	public void insertPeople(People people);
}
