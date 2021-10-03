package com.model;
import javax.persistence.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.*;

@Component
public class BookingDetailService {
	@Autowired
	BookingDetailDAO bookingDetailDAOImpl;
	
	public void save(BookingDetail bookingDetail)
	{
		bookingDetailDAOImpl.saveBookingDetail(bookingDetail);
	}
	
	public BookingDetail find(int id) 
	{
		return bookingDetailDAOImpl.findBoookingDetail(id);
	}
	
	public List<BookingDetail> getAll()
	{
		return bookingDetailDAOImpl.findAll();
	}
}