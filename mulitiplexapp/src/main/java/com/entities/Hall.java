package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hall {
	@Id
	@GeneratedValue
	int hallId;
	@OneToMany(cascade=CascadeType.ALL)
	List<Shows> shows;
	@OneToMany(cascade=CascadeType.ALL)
	List<HallCapacity> hallCapacity;
	String hallDesc;
	int totalCapacity;
	public int getHallId() {
		return hallId;
	}
	public List<Shows> getShows() {
		return shows;
	}
	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}
	public List<HallCapacity> getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(List<HallCapacity> hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	public String getHallDesc() {
		return hallDesc;
	}
	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public Hall(List<Shows> shows, List<HallCapacity> hallCapacity, String hallDesc, int totalCapacity) {
		super();
		this.shows = shows;
		this.hallCapacity = hallCapacity;
		this.hallDesc = hallDesc;
		this.totalCapacity = totalCapacity;
	}
	public Hall() {
		super();
	}
	public Hall(String hallDesc, int totalCapacity) {
		super();
		this.hallDesc = hallDesc;
		this.totalCapacity = totalCapacity;
	}
	
	
	
}