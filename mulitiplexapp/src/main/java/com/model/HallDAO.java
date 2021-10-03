package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.entities.*;



@Component
public interface HallDAO {
	
	public Hall findHall(int userId);
	public List<Hall> findAll();
	public void saveHall(Hall hall);

}
