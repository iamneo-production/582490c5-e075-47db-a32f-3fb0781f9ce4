package com.diploma.admisssion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diploma.admisssion.model.CourseRegistration;


@Repository
public interface CourseRegistrationRepo extends JpaRepository<CourseRegistration, Integer>{

	CourseRegistration findByUseremailAndCourseid(String useremail, int courseid);
	
	List<CourseRegistration> findByUserid(int userid);
	
	int deleteByCourseidAndUserid(int courseid, int userid);

}
