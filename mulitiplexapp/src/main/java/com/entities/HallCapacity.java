package com.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class HallCapacity implements Serializable {
	@Id
	@GeneratedValue
	int hallCapacityId;
	@ManyToOne(cascade=CascadeType.ALL)
	Hall hall;
	@ManyToOne(cascade=CascadeType.ALL)
	SeatType seatType;
	int seatCount;
	public int getHallCapacityId() {
		return hallCapacityId;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHallCapaityId(int hallCapacityId) {
		this.hallCapacityId=hallCapacityId;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public HallCapacity(Hall hall, SeatType seatType, int seatCount) {
		super();
		this.hall = hall;
		this.seatType = seatType;
		this.seatCount = seatCount;
	}
	
	public HallCapacity(int seatCount) {
		super();
		this.seatCount = seatCount;
	}
	public HallCapacity() {
		super();
	}
	
}