package com.diploma.admisssion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diploma.admisssion.model.Institutes;

@Repository
public interface InstituteRepo extends JpaRepository<Institutes, Integer>{

    Institutes findById(int id);
    
}
