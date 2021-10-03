package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
@Entity
public class Movies {
	
	@Id
	@GeneratedValue
	int movieId;
	@OneToMany(cascade=CascadeType.ALL)
	List<Shows> shows;
	String movieName;
	
	public Movies(List<Shows> shows, String movieName) {
		super();
		this.shows = shows;
		this.movieName = movieName;
	}

	public int getMovieId() {
		return movieId;
	}

	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Movies(String movieName) {
		super();
		this.movieName = movieName;
	}

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}