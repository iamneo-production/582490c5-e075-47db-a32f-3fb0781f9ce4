package com.diploma.admisssion.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
    private long id;
	private long instituteID;
    private String title;
    private String description;
public Course(long id,long instituteID, String title, String description) {
	super();
	this.id = id;
	this.instituteID =instituteID ;
	this.title = title;
	this.description = description;
	
}
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
public long getid() {
	return id;
}
public void setid(long id) {
	this.id= id;
}
public long getinstituteID() {
	return instituteID;
}
public void setinstituteID(long instituteID) {
	this.instituteID= instituteID;
}


public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	
	return "Course [ instituteID=" + instituteID + ", id=" + id + ", title=" + title + ", description=" + description + "]";
}

}
