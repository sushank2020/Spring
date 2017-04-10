package com.sushank.demo;

import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import com.sushank.demo.model.Student;


@MapperScan("com.sushank.database")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) 
public class SpringBootDemoApplication {
	public static HashMap<Long,Student> hmStudent;

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootDemoApplication.class, args);
		
		 /*ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
		 
	        String[] beanNames = ctx.getBeanDefinitionNames();
	         
	        Arrays.sort(beanNames);
	         
	        for (String beanName : beanNames) 
	        {
	            //System.out.println(beanName);
	        }*/
	        
	        SpringApplication.run(SpringBootDemoApplication.class, args);
	   
	}
}
