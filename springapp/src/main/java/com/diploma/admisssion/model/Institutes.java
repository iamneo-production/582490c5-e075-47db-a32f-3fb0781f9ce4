package com.diploma.admisssion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Institutes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private int id;
    private String institueName;
    private String institutePlace;
    private String imgLocation;

    public Institutes() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitueName() {
        return institueName;
    }

    public void setInstitueName(String institueName) {
        this.institueName = institueName;
    }

    public String getInstitutePlace() {
        return institutePlace;
    }

    public void setInstitutePlace(String institutePlace) {
        this.institutePlace = institutePlace;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }



    
    
}
