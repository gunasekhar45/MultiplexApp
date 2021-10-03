package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.entities.*;



@Component
public interface HallCapacityDAO {
	
	public HallCapacity findHallCapacity(int hallCapacityId);
	public List<HallCapacity> findAll();
	public void saveHallCapacity(HallCapacity hallcapacity);

}
