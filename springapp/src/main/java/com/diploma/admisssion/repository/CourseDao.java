package com.diploma.admisssion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diploma.admisssion.model.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
