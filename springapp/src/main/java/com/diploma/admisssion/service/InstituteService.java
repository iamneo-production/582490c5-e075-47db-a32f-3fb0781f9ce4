package com.diploma.admisssion.service;

import java.util.List;


import com.diploma.admisssion.exceptions.InstituteAlreadyExistException;
import com.diploma.admisssion.model.Institutes;

public interface InstituteService {

    public List<Institutes> getAllInstitutes();

    public Institutes getInstitutebyId(int id);
    public Institutes addInstitute(Institutes ins) throws InstituteAlreadyExistException;

    public Institutes instituteDetails(int id);

    public int deletefromCourseReg(String institueName);

    public int deleteByInstituteId(int id);

    public int deletefromCourses(int institutesid);

    public Institutes saveInstitute(Institutes ins);

    public void deleteAll();

    public Institutes findByInstituteName(String instituteName) throws InstituteAlreadyExistException;
    
}
