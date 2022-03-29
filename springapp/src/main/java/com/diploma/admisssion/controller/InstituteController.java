package com.diploma.admisssion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import com.diploma.admisssion.exceptions.InstituteNotFoundException;
import com.diploma.admisssion.model.Institutes;
import com.diploma.admisssion.model.UserRatings;
import com.diploma.admisssion.service.InstituteService;

@RestController
@RequestMapping("/institutes")
@CrossOrigin
public class InstituteController {

    Logger logger = LoggerFactory.getLogger(InstituteController.class);

    @Autowired
    private InstituteService instservice;

    @GetMapping("/getAll")
	@ApiOperation("Fetch all the Institutes")
    public ResponseEntity<List<Institutes>> getAll(){
        return new ResponseEntity<List<Institutes>>(instservice.getAllInstitutes(),HttpStatus.OK);
    }

    @GetMapping("/getById")
	@ApiOperation("Fetch all the Institutes")
    public ResponseEntity<Institutes> getById(@RequestParam(required = true) int id){
        if(instservice.getInstitutebyId(id)!=null)
        {
            return new ResponseEntity<Institutes>(instservice.getInstitutebyId(id),HttpStatus.OK);
        }
        return new ResponseEntity<Institutes>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/searchInstitute")
    @ApiOperation("Search Institutes")
    public ResponseEntity<List<Institutes>> searchInstitutebyName(@RequestParam(required = true) String institutename) throws InstituteNotFoundException{
        List<Institutes> institutes = instservice.searchInstitute(institutename);
        return new ResponseEntity<>(institutes,HttpStatus.OK);
    }

    @PostMapping("/rate")
    @ApiOperation("Rate and Review the Institute")
    public ResponseEntity<UserRatings> rateInstitute(@RequestBody UserRatings ur){
        UserRatings ursp = instservice.saveRating(ur);
        logger.info(ursp.toString());

        double sum=0;
        List<UserRatings> userratings = instservice.getInstituteRating(ur.getInstituteName());
        for(UserRatings urr: userratings){
            sum+=urr.getRating();
        }
        double avg = sum/userratings.size();
        Institutes inst = instservice.getInstituteDetails(ur.getInstituteName());
        inst.setRating(avg);
        instservice.saveRating(inst);

        return new ResponseEntity<UserRatings>(ursp,HttpStatus.OK);
    }

    @GetMapping("/getRatingbyInstituteName")
    @ApiOperation("Fetch the rating of the Institute")
    public ResponseEntity<List<UserRatings>> getRatingbyInstituteName(@RequestParam(required = true) String instituteName ){
        List<UserRatings> userratings = instservice.getInstituteRating(instituteName);
        return new ResponseEntity<List<UserRatings>>(userratings,HttpStatus.OK);
    }




    
}
