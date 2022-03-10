package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.model.Institutes;

public interface InstituteService {

    public List<Institutes> getAllInstitutes();

    public Institutes getInstitutebyId(int id);
    
}
