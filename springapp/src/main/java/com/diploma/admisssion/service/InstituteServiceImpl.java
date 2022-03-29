package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.exceptions.InstituteAlreadyExistException;
import com.diploma.admisssion.model.Institutes;
import com.diploma.admisssion.repository.CourseRegistrationRepo;
import com.diploma.admisssion.repository.CourseRepo;
import com.diploma.admisssion.repository.InstituteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImpl  implements InstituteService{

    @Autowired
    private InstituteRepo instrepo;
    @Autowired
	private CourseRegistrationRepo crgrepo;
    @Autowired
	private CourseRepo courserepo;

    @Override
    public List<Institutes> getAllInstitutes() {
        return instrepo.findAll();
    }

    @Override
    public Institutes getInstitutebyId(int id) {
        if(instrepo.findById(id)!=null)
        {
            return instrepo.findByInstitutesid(id);
        }
        return null;
    }

    @Override
    public Institutes addInstitute(Institutes ins) throws InstituteAlreadyExistException{
        
        if(instrepo.findByInstitueName(ins.getInstitueName())!=null){
            throw new InstituteAlreadyExistException(ins.getInstitueName());
        }
		return instrepo.save(ins);
	}

    @Override
    public Institutes instituteDetails(int id) {
        
        if(instrepo.findByInstitutesid(id)!=null){
			return instrepo.findByInstitutesid(id);
		}
		return null;
    }

    @Override
    public int deletefromCourseReg(String institute_name) {
        
        return crgrepo.deleteByInstituteName(institute_name);
    }

    @Override
    public int deleteByInstituteId(int id) {
        
        return instrepo.deleteByInstitutesid(id);
    }

    @Override
    public int deletefromCourses(int institutesid) {
        return courserepo.deleteByInstituteid(institutesid);
    }

    @Override
    public Institutes saveInstitute(Institutes ins) {
        
        return instrepo.save(ins);
    }

    @Override
    public void deleteAll() {
        instrepo.deleteAll();
    }

    @Override
    public Institutes findByInstituteName(String instituteName)throws InstituteAlreadyExistException {
        if(instrepo.findByInstitueName(instituteName)!=null){
            throw new InstituteAlreadyExistException(instituteName);
        }
        return instrepo.findByInstitueName(instituteName);
    }
}
