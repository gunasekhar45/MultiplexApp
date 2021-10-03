package com.model;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.entities.*;



@Component
public interface BookingDAO {
	
	public Booking findBoooking(int userId);
	public List<Booking> findAll();
	public void saveBooking(Booking booking);
	
	public BookingDetail booking(Booking booking, int noOfSeats, SeatType seatType);
	Booking deleteBooking(int id, int active);

}
