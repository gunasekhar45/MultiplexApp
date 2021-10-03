package com.model;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.*;

@Component
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	SessionFactory sessionFactory;
	public void saveUser(Users user)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		session.flush();
		session.close();
		tx.commit();
	}
	public Users findUser(int id)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Users user=session.get(Users.class, id);
tx.commit();
		return user;
	}
	
	public boolean updateUser(Users user)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(user);
		session.flush();
		session.close();
		tx.commit();
		return true;
	}
	public List<Users> findAll()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query query=session.createQuery("select i from Users i");
		tx.commit();
		return query.list();
	}
	public String validateUser(Users user) {
		int flag=0;
		List<Users> list=new ArrayList<Users>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		list=this.findAll();
		for(Users u:list) {
			if(u.getUserId()==user.getUserId()) {
				if(u.getMobileNo()==user.getMobileNo()) {
					if((u.getEmailId()).equals((user.getEmailId()))) {
						if((u.getUserType())==(user.getUserType())){
							if((u.getUserName()).equals((user.getUserName()))){
								flag=1;
								break;
								
							}
							
						}
					}
				}
			}
		}
		
		
		if(flag==1) {
tx.commit();
			return "Valid User";
		}
		else {
			this.saveUser(user);
			tx.commit();
			return "New User Saved";
		}
		
	}
}