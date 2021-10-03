package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.entities.*;



@Component
public interface MoviesDAO {
	
	public Movies findMovies(int userId);
	public List<Movies> findAll();
	public void saveMovies(Movies movies);
	public Movies QueryMovies(String movieName,int hallId);

}
