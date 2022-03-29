package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.exceptions.InstituteNotFoundException;
import com.diploma.admisssion.model.Institutes;
import com.diploma.admisssion.model.UserRatings;

public interface InstituteService {

    public List<Institutes> getAllInstitutes();

    public Institutes getInstitutebyId(int id);

    public Institutes getInstituteDetails(String instituteName);

    public Institutes saveRating(Institutes inst);

    public UserRatings saveRating(UserRatings ur);

    public List<Institutes> searchInstitute(String instituteName) throws InstituteNotFoundException;

    public List<UserRatings> getInstituteRating(String institutename);

    public Institutes getInstitutebyName(String institutename) throws InstituteNotFoundException;
    
}
