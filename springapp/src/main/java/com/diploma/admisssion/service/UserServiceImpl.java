package com.diploma.admisssion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

import com.diploma.admisssion.exceptions.InvalidUserException;
import com.diploma.admisssion.exceptions.UserAlreadyExistsException;
import com.diploma.admisssion.model.User;
import com.diploma.admisssion.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	
	
	@Override
	public User saveUser(User user) throws UserAlreadyExistsException{
		if(checkIfUserExist(user.getEmail()))
		{
			throw new UserAlreadyExistsException(user.getEmail());
		}
		Base64.Encoder encoder = Base64.getEncoder();  
		user.setPwd(encoder.encodeToString(user.getPwd().getBytes()));
		user.setConfirmpwd(encoder.encodeToString(user.getConfirmpwd().getBytes()));
		userRepo.save(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@Override
    public boolean checkIfUserExist(String email) {
        return userRepo.findByEmail(email) !=null ? true : false;
    }

	@Override
	public User loginUser(User user) throws InvalidUserException {
		if(isValidUser(user.getEmail(),user.getPwd())){
			String email = user.getEmail();
			Base64.Encoder encoder = Base64.getEncoder();
			String pwd = encoder.encodeToString(user.getPwd().getBytes());
			return userRepo.findByEmailAndPwd(email,pwd);
		}
		throw new InvalidUserException();
	}

	private boolean isValidUser(String email, String password){
		Base64.Encoder encoder = Base64.getEncoder();
		String pwd = encoder.encodeToString(password.getBytes());
		return userRepo.findByEmailAndPwd(email, pwd) != null ? true:false;
	}


	

	

	

	
	
	

}
