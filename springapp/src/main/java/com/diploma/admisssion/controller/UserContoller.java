package com.diploma.admisssion.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diploma.admisssion.model.User;
import com.diploma.admisssion.service.UserService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserContoller {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/add")
	@ApiOperation("Add users to the Portal")
	public String add(@RequestBody User user) {
		if(userservice.saveUser(user)!=null)
		{
			return "User added successfully";
		}
		return "User already exits";
	}
	
	@PostMapping("/loginuser")
	@ApiOperation("Authenticated and Authorized Login")
	public ResponseEntity<User> loginuser(@RequestBody User user) {
		if(userservice.isValid(user.getEmail(), user.getPwd()))
		{
			if(userservice.UserDetails(user.getEmail(),user.getPwd())!=null)
			{
				return new ResponseEntity<User>(userservice.UserDetails(user.getEmail(),user.getPwd()),HttpStatus.OK);
			}
		}		
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all the records of users")
	public List<User> list(){
        return userservice.getAllUsers();
    }
	

}
