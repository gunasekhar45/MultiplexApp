package com.model;
import javax.persistence.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.*;

@Component
public class HallCapacityService {
	@Autowired
	HallCapacityDAO hallCapacityDAOImpl;
	
	public void save(HallCapacity hallCapacity)
	{
		hallCapacityDAOImpl.saveHallCapacity(hallCapacity);
	}
	
	public HallCapacity find(int id) 
	{
		return hallCapacityDAOImpl.findHallCapacity(id);
	}
	
	public List<HallCapacity> getAll()
	{
		return hallCapacityDAOImpl.findAll();
	}
	
}