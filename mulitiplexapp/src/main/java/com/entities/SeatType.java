package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SeatType {
	@Id
	@GeneratedValue
	int seatTypeId;
	String seatTypeDesc;
	float seatFare;
	@OneToMany(cascade=CascadeType.ALL)
	List<HallCapacity> hallCapacity;
	@OneToMany(cascade=CascadeType.ALL)
	List<BookingDetail> bookingDetail;
	public int getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}
	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}
	public float getSeatFare() {
		return seatFare;
	}
	public void setSeatFare(float seatFare) {
		this.seatFare = seatFare;
	}
	public List<HallCapacity> getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(List<HallCapacity> hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	public List<BookingDetail> getBookingDetail() {
		return bookingDetail;
	}
	public void setBookingDetail(List<BookingDetail> bookingDetail) {
		this.bookingDetail = bookingDetail;
	}
	public SeatType(String seatTypeDesc, float seatFare, List<HallCapacity> hallCapacity,
			List<BookingDetail> bookingDetail) {
		super();
		this.seatTypeDesc = seatTypeDesc;
		this.seatFare = seatFare;
		this.hallCapacity = hallCapacity;
		this.bookingDetail = bookingDetail;
	}
	public SeatType() {
		super();
	}

	public SeatType(String seatTypeDesc, float seatFare) {
		super();
		this.seatTypeDesc = seatTypeDesc;
		this.seatFare = seatFare;
	}
	
}