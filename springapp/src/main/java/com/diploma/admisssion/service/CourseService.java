package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.model.CourseRegistration;
import com.diploma.admisssion.model.Courses;

public interface CourseService {
	
	public List<Courses> getAllCourses();
	
	public List<Courses> getCoursebyTitle(String title);
	
	public boolean CheckifAlreadyEnrolled(String useremail, String title);
	
	public CourseRegistration enrollCourse(CourseRegistration crg);
	
	public List<CourseRegistration> viewenrolled(String email);
	
	public int deleteenrolled(int regid, String useremail);

	public Courses addCourse(Courses crs);

	public Courses courseDetails(int id);

	public Courses saveCourse(Courses crs);

	public int deletebyId(int courseid);

	public void deleteAll();


}
