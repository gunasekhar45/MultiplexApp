package com.model;
import javax.persistence.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.*;

@Component
public class HallService {
	@Autowired
	HallDAO hallDAOImpl;
	
	public void save(Hall hall)
	{
		hallDAOImpl.saveHall(hall);
	}
	
	public Hall find(int id) 
	{
		return hallDAOImpl.findHall(id);
	}
	
	public List<Hall> getAll()
	{
		return hallDAOImpl.findAll();
	}
	
}