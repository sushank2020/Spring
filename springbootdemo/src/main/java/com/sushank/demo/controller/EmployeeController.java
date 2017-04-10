package com.sushank.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushank.database.PeopleMapper;
import com.sushank.database.UserMapper;
import com.sushank.demo.model.Employee;
import com.sushank.demo.model.People;
import com.sushank.demo.model.User;

@RestController
public class EmployeeController {
	@Autowired
    private UserMapper userMapper;
	
	@Autowired
	private PeopleMapper peopleMapper;
	
	@RequestMapping("/name")
    public List<Employee> getEmployees() 
    {
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1,"sushank","kumar","sushank.kumar29@gmail.com"));
		return employeesList;
    }
	
	@RequestMapping("/user")
	public List<User> findAllUsers() {
        List<User> users = userMapper.findAllUsers();
        return users;
    }
	@RequestMapping("/people")
	public List<People> findAllPeoples() {
        List<People> peoples = peopleMapper.findAllPeoples();
        return peoples;
    }
	
	@RequestMapping("/insert")
	public People insertPeople(){
		People people = new People();
		people.setId(10);
		people.setFirstName("raj");
		people.setLastName("kumar");
		people.setEmailId("raj.kumar@gmail.com");
		System.out.println("people:"+people.getId());
		System.out.println("people:"+people.getFirstName());
		System.out.println("people:"+people.getLastName());
		System.out.println("people:"+people.getEmailId());
		
		peopleMapper.insertPeople(people);
		return people;
	}
	
	@RequestMapping("/createuser")
	public User createUser() {
        User user = new User(0, "Shivaaa", "shivaaa@gmail.com");
        userMapper.insertUser(user);
        return user;
    }

}
