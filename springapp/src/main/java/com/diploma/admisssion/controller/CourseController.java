package com.diploma.admisssion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import com.diploma.admisssion.model.CourseRegistration;
import com.diploma.admisssion.model.Courses;
import com.diploma.admisssion.service.CourseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all the records of courses")
	public ResponseEntity<List<Courses>> getAll(){
		return new ResponseEntity<List<Courses>>(courseservice.getAllCourses(),HttpStatus.OK);
	}
	
	@GetMapping("/getbyTitle")
	@ApiOperation("Fetch the course by title")
	public ResponseEntity<List<Courses>> getbyTitle(@RequestParam(required = true) String title){
		
		List<Courses> courses = new ArrayList<Courses>();
		courseservice.getCoursebyTitle(title).forEach(courses::add);
		if(courses.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
		
	}
	
	@PostMapping("/enroll")
	@ApiOperation("Enroll into a new course")
	public ResponseEntity<String> enroll(@RequestBody CourseRegistration crg) {
		if(courseservice.enrollCourse(crg)!=null)
		{
			return new ResponseEntity<String>("Course enrolled successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Course already enrolled",HttpStatus.IM_USED);
	}
	
	@GetMapping("/viewenrolled")
	@ApiOperation("View enrolled courses")
	public ResponseEntity<List<CourseRegistration>> viewenrolled(@RequestParam(required = true) int userid){
		
		List<CourseRegistration> enrolled = new ArrayList<CourseRegistration>();
		enrolled = courseservice.viewenrolled(userid);
		if(enrolled.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(enrolled,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecourse")
	@Transactional
	@ApiOperation("Delete enrolled courses")
	public ResponseEntity<String> deleteCourse(@RequestParam(required = true) int userid, @RequestParam(required = true) int courseid){
		if(courseservice.deleteenrolled(courseid,userid)>0)
		{
			return new ResponseEntity<>("Course Unenrolled Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}
