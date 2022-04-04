package com.diploma.admisssion.repository;

import com.diploma.admisssion.model.UserRatings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepo extends JpaRepository<UserRatings, Integer>{

    List<UserRatings> findByInstitutename(String institutename);
    
}
