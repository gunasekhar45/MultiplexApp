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
public class HallCapacityDAOImpl implements HallCapacityDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveHallCapacity(HallCapacity hallcapacity)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(hallcapacity);
		session.flush();
		session.close(); 
		tx.commit();
	}
	
	
	public List<HallCapacity> findAll()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query query=session.createQuery("select i from HallCapacity i");
		tx.commit();
		return query.list();
	}

	@Override
	public HallCapacity findHallCapacity(int hallId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		HallCapacity hallcapacity=session.get(HallCapacity.class,hallId);
tx.commit();
		return hallcapacity;
	}
	
	
	
	
	
}