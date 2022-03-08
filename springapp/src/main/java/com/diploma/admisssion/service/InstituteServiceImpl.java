package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.model.Institutes;
import com.diploma.admisssion.repository.InstituteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImpl  implements InstituteService{

    @Autowired
    private InstituteRepo instrepo;

    @Override
    public List<Institutes> getAllInstitutes() {
        return instrepo.findAll();
    }

    @Override
    public Institutes getInstitutebyId(int id) {
        if(instrepo.findById(id)!=null)
        {
            return instrepo.findById(id);
        }
        return null;
    }
    
}
