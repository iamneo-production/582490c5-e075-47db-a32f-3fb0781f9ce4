package com.diploma.admisssion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Courses {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int course_id;
	private String title;
	private String course_desc;
	@Column(unique = true)
	private int institute_id;
	
	public Courses() {
		
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCourse_desc() {
		return course_desc;
	}

	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}

	public int getInstitute_id() {
		return institute_id;
	}

	public void setInstitute_id(int institute_id) {
		this.institute_id = institute_id;
	}
	
	
	
	

}
