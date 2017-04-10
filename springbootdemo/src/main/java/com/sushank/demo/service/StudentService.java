package com.sushank.demo.service;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sushank.demo.SpringBootDemoApplication;
import com.sushank.demo.model.Student;

@RestController
@RequestMapping(value="/rest/student")
class StudentService{
 
   @RequestMapping(value="/",method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return SpringBootDemoApplication.hmStudent;
   }
   
   @RequestMapping(value="/add",method = RequestMethod.POST)
   public Student addStudent(@RequestParam(value="name") String name
         ,@RequestParam(value="subject",defaultValue = "unknown") String subject){
    
      Student student=new Student(name,subject);
      SpringBootDemoApplication.hmStudent.put(new Long(student.getId()),student);
      return student;
    
   }
   
   @RequestMapping(value="/update",method = RequestMethod.PUT)
   public Student updateStudent(@RequestBody Student student) throws Exception {
    
      if(SpringBootDemoApplication.hmStudent.containsKey(new Long(student.getId()))){
    	  SpringBootDemoApplication.hmStudent.put(new Long(student.getId()),student);
      }else{
         throw new Exception("Student "+student.getId()+" does not exists");
      }
    
      return student;
   }
   
   @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
   public Student deleteStudent(@PathVariable long id) throws Exception {
    
      Student student;
    
      if(SpringBootDemoApplication.hmStudent.containsKey(new Long(id))){
         student=SpringBootDemoApplication.hmStudent.get(new Long(id));
         SpringBootDemoApplication.hmStudent.remove(new Long(id));
      }else{
         throw new Exception("Student "+id+" does not exists");
      }
      return student;
   }
   
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Student getStudent(@PathVariable long id){
      return SpringBootDemoApplication.hmStudent.get(new Long(id));
   }
}
