package com.diploma.admisssion.service;

import java.util.List;

import com.diploma.admisssion.exceptions.InvalidUserException;
import com.diploma.admisssion.exceptions.UserAlreadyExistsException;
import com.diploma.admisssion.model.User;

public interface UserService {
	
	public User saveUser(User user) throws UserAlreadyExistsException;
	
    public List<User> getAllUsers();
    
    public boolean checkIfUserExist(String email);

    public User loginUser(User user) throws InvalidUserException; 
    
   

}
