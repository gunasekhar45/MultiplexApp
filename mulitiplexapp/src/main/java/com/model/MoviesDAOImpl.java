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
public class MoviesDAOImpl implements MoviesDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveMovies(Movies movies)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(movies);
		session.flush();
		session.close(); 
		tx.commit();
	}
	public List<Movies> findAll()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query query=session.createQuery("select i from Movies i");
		tx.commit();
		return query.list();
	}

	@Override
	public Movies findMovies(int movieId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Movies movies=session.get(Movies.class,movieId);
tx.commit();
		return movies;
	}
	
	public Movies QueryMovies(String movieName,int hallId){
		int flag=0;
		List<Movies> list=new ArrayList<Movies>();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		list=this.findAll();
		for(Movies m:list) {
			if((m.getMovieName()).equals(movieName)) {
				session.flush();
				session.close();
				tx.commit();
				return m;
			}
		}
		return new Movies();
	}
	}
	
	
	
	
