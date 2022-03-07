package com.diploma.admisssion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseRegistration {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int reg_id;
	private int userid;
	private String useremail;
	private int HSCmarks;
	private int courseid;
	private String title;
	private int institute_id;
	
	public CourseRegistration() {
		
	}

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public int getUser_id() {
		return userid;
	}

	public void setUser_id(int userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public int getHSCmarks() {
		return HSCmarks;
	}

	public void setHSCmarks(int hSCmarks) {
		HSCmarks = hSCmarks;
	}

	public int getCourse_id() {
		return courseid;
	}

	public void setCourse_id(int courseid) {
		this.courseid = courseid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getInstitute_id() {
		return institute_id;
	}

	public void setInstitute_id(int institute_id) {
		this.institute_id = institute_id;
	}
	
	
	
	

}
