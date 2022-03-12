package com.diploma.admisssion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/getbyId")
	@ApiOperation("Fetch the course by Course id")
	public ResponseEntity<Courses> getbyId(@RequestParam(required = true) int id){
		if(courseservice.courseDetails(id)!=null){
			return  new ResponseEntity<Courses>(courseservice.courseDetails(id), HttpStatus.OK);
		}
		return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add")
	@ApiOperation("Adding a Course")
	public ResponseEntity<String> add(@RequestBody Courses crs){
		if(courseservice.addCourse(crs)!=null){
			return  new ResponseEntity<String>("Course added successfully", HttpStatus.OK);
		}
		return  new ResponseEntity<>("Course was already added", HttpStatus.ALREADY_REPORTED);
	}

	@PutMapping("/edit/{id}")
	@ApiOperation("Editing a Course")
	public ResponseEntity<Courses> editCourse(@PathVariable("id") int id, @RequestBody Courses crs){
		if(courseservice.courseDetails(id)!=null){
			Courses crsdt = courseservice.courseDetails(id);
			crsdt.setTitle(crs.getTitle());
			crsdt.setCourse_desc(crs.getCourse_desc());
			crsdt.setInstituteid(crs.getInstituteid());
			crsdt.setInstitute_name(crs.getInstitute_name());
			return new ResponseEntity<Courses>(courseservice.saveCourse(crsdt),HttpStatus.OK);
		}
		return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{id}")
	@Transactional
	@ApiOperation("Delete a course")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") int id){
		if(courseservice.courseDetails(id)!=null){
			if(courseservice.deletebyId(id)>0){
				return  new ResponseEntity<String>("Course Deleted Successfully", HttpStatus.OK);
			}
		}
		return  new ResponseEntity<>("Course not able to delete", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteAll")
	@Transactional
	@ApiOperation("Delete all courses")
	public ResponseEntity<HttpStatus> deleteAllCourse(){
		courseservice.deleteAll();
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
	public ResponseEntity<List<CourseRegistration>> viewenrolled(@RequestParam(required = true)String useremail){
		
		List<CourseRegistration> enrolled = new ArrayList<CourseRegistration>();
		enrolled = courseservice.viewenrolled(useremail);
		if(enrolled.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(enrolled,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteenrolled")
	@Transactional
	@ApiOperation("Delete enrolled courses")
	public ResponseEntity<String> deleteCourse(@RequestParam(required = true) int regid, @RequestParam(required = true) String useremail){
		if(courseservice.deleteenrolled(regid,useremail)>0)
		{
			return new ResponseEntity<>("Course Unenrolled Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}
