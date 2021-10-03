package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.entities.*;



@Component
public interface SeatTypeDAO {
	
	public SeatType findSeatType(int userId);
	public List<SeatType> findAll();
	public void saveSeatType(SeatType seattype);

}
