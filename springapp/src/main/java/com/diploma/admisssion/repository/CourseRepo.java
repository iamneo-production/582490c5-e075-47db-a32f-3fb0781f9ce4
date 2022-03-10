package com.diploma.admisssion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diploma.admisssion.model.Courses;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer>{
	
	List<Courses> findByTitleContaining(String title);

	Courses findByCourseid(int courseid);

	Courses findByTitleAndInstituteid(String title, int instituteid);

	int deleteByCourseid(int courseid);


}
