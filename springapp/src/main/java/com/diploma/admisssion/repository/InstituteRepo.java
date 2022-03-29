package com.diploma.admisssion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.diploma.admisssion.model.Institutes;

@Repository
public interface InstituteRepo extends JpaRepository<Institutes, Integer>{

    Institutes findByInstitutesid(int institutesid);

    Institutes findByInstitueName(String institueName);

    List<Institutes> findByInstitueNameContaining(String institueName);
    
}
