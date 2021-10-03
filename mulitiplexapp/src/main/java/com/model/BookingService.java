package com.model;
import javax.persistence.Entity;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.*;

@Component
public class BookingService {
	@Autowired
	BookingDAO bookingDAOImpl;
	
	public void save(Booking booking)
	{
		bookingDAOImpl.saveBooking(booking);
	}
	
	public Booking find(int id) 
	{
		return bookingDAOImpl.findBoooking(id);
	}
	
	public List<Booking> getAll()
	{
		return bookingDAOImpl.findAll();
	}
	
	public BookingDetail booking(Booking booking,int noOfSeats,SeatType seatType) {
		// TODO Auto-generated method stub
		return bookingDAOImpl.booking(booking,noOfSeats,seatType);
		}
	public Booking deleteBooking(int id,int active) {
		return bookingDAOImpl.deleteBooking(id, active);
	}

	}