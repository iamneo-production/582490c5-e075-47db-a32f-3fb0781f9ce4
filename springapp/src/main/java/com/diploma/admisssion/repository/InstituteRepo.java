package com.diploma.admisssion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diploma.admisssion.model.Institutes;

@Repository
public interface InstituteRepo extends JpaRepository<Institutes, Integer>{

    Institutes findByInstitutesid(int institutesid);
    Institutes findByInstitutesidAndInstitueName(int institutesid, String institute_name);
    int deleteByInstitutesid(int institutesid);
    Institutes findByInstitueName(String institueName);
    
}
