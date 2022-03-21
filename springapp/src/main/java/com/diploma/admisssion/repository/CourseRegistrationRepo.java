package com.diploma.admisssion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diploma.admisssion.model.CourseRegistration;


@Repository
public interface CourseRegistrationRepo extends JpaRepository<CourseRegistration, Integer>{

	CourseRegistration findByUseremailAndTitle(String useremail, String title);

	List<CourseRegistration> findByUseremail(String useremail);

	CourseRegistration findByRegid(int regid);

	List<CourseRegistration> findByTitle(String title);

	int deleteByTitle(String title);
	
	int deleteByRegidAndUseremail(int regid, String useremail);

}
