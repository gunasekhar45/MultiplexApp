package com.model;
import javax.persistence.Entity;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.*;

@Component
public class BookingDetailDAOImpl implements BookingDetailDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveBookingDetail(BookingDetail bookingdetail)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(bookingdetail);
		session.flush();
		session.close(); 
		tx.commit();
	}
	
	
	
	public List<BookingDetail> findAll()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query query=session.createQuery("select i from BookingDetail i");
		tx.commit();
		return query.list();
	}
	@Override
	public BookingDetail findBoookingDetail(int bookingId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		BookingDetail bookingdetail=session.get(BookingDetail.class,bookingId);
tx.commit();
		return bookingdetail;
	}
	
	
	
}