package com.diploma.admisssion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;

import com.diploma.admisssion.model.User;
import com.diploma.admisssion.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		if(checkIfUserExist(user.getEmail()))
		{
			return null;
		}
		Base64.Encoder encoder = Base64.getEncoder();  
		user.setPwd(encoder.encodeToString(user.getPwd().getBytes()));
		user.setConfirmpwd(encoder.encodeToString(user.getConfirmpwd().getBytes()));
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@Override
    public boolean checkIfUserExist(String email) {
        return userRepo.findByEmail(email) !=null ? true : false;
    }

	@Override
	public boolean isValid(String email, String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String pwd = encoder.encodeToString(password.getBytes());
		if(validemailandpwd(email,pwd))
		{
			return true;
		}
		return false;
	}

	private boolean validemailandpwd(String email, String pwd) {
		
		if(userRepo.findByEmailAndPwd(email, pwd).size()!=0)
		{
			return true;
		}
		return false;
	}

	@Override
	public User UserDetails(String email, String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String pwd = encoder.encodeToString(password.getBytes());
		if(userRepo.findByEmailAndPwd(email, pwd).size()!=0)
		{
			return userRepo.findByEmailAndPwd(email, pwd).get(0);
		}
		return null;
	
	}

	

	
	
	

}
