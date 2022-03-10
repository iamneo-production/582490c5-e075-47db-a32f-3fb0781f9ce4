package com.diploma.admisssion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import com.diploma.admisssion.model.Institutes;
import com.diploma.admisssion.service.InstituteService;

@RestController
@RequestMapping("/institutes")
@CrossOrigin
public class InstituteController {

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




    
}
