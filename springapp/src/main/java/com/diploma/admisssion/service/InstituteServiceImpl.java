package com.diploma.admisssion.service;

import java.util.ArrayList;
import java.util.List;

import com.diploma.admisssion.exceptions.InstituteNotFoundException;
import com.diploma.admisssion.model.Institutes;
import com.diploma.admisssion.model.UserRatings;
import com.diploma.admisssion.repository.InstituteRepo;
import com.diploma.admisssion.repository.RatingsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImpl  implements InstituteService{

    @Autowired
    private InstituteRepo instrepo;

    @Autowired
    private RatingsRepo raterepo;

    @Override
    public List<Institutes> getAllInstitutes() {
        return instrepo.findAll();
    }

    @Override
    public Institutes getInstitutebyId(int id) {
        if(instrepo.findByInstitutesid(id)!=null)
        {
            return instrepo.findByInstitutesid(id);
        }
        return null;
    }

    @Override
    public UserRatings saveRating(UserRatings ur) {
        return raterepo.save(ur);
    }

    @Override
    public List<UserRatings> getInstituteRating(String institutename) {
        return raterepo.findByInstitutename(institutename);
    }

    @Override
    public Institutes getInstituteDetails(String instituteName) {
        return instrepo.findByInstitueName(instituteName);
    }

    @Override
    public Institutes saveRating(Institutes inst) {
        return instrepo.save(inst);
    }

    @Override
    public Institutes getInstitutebyName(String institutename) throws InstituteNotFoundException {
        if(instrepo.findByInstitueName(institutename)!=null){
            return instrepo.findByInstitueName(institutename);
        }
        throw new InstituteNotFoundException(institutename);
    }

    @Override
    public List<Institutes> searchInstitute(String instituteName)  throws InstituteNotFoundException{
        List<Institutes> instiutes = new ArrayList<>();
        instrepo.findByInstitueNameContaining(instituteName).forEach(instiutes::add);
        if(instiutes.isEmpty()){
            throw new InstituteNotFoundException(instituteName);
        }
        return instiutes;
    }
    
}
