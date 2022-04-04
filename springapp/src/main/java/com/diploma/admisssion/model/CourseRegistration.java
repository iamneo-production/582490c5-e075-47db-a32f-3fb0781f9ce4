package com.diploma.admisssion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseRegistration {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int regid;
	private String useremail;
	private String username;
	private float HSCmarks;
	private String coursedesc;
	private String title;
	private String instituteName;
	private String academicYear;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getAcademicYear(){
		return academicYear;
	}

	public void setAcademicYear(String academicYear){
		this.academicYear=academicYear;
	}



	public CourseRegistration() {
		
	}

	public int getRegid() {
		return regid;
	}



	public void setRegid(int regid) {
		this.regid = regid;
	}


	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public float getHSCmarks() {
		return HSCmarks;
	}

	public void setHSCmarks(float hSCmarks) {
		HSCmarks = hSCmarks;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoursedesc() {
		return coursedesc;
	}

	public void setCoursedesc(String coursedesc) {
		this.coursedesc = coursedesc;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}


	
	
	
	

}
