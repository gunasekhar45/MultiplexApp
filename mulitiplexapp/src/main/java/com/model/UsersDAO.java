package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.entities.*;



@Component
public interface UsersDAO {
	
	public Users findUser(int userId);
	public boolean updateUser(Users user);
	public List<Users> findAll();
	public void saveUser(Users user);
	
	public String validateUser(Users user);

}