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
public class HallDAOImpl implements HallDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveHall(Hall hall)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(hall);
		session.flush();
		session.close(); 
		tx.commit();
	}
	
	public List<Hall> findAll()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query query=session.createQuery("select i from Hall i");
		tx.commit();
		return query.list();
	}

	@Override
	public Hall findHall(int hallId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Hall hallcapacity=session.get(Hall.class,hallId);
tx.commit();
		return hallcapacity;
	}
	
	
	
	
	
}