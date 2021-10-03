package com.entities;



import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Booking {
public Booking(){

}
@Id
@GeneratedValue
int bookingId;
@ManyToOne(cascade=CascadeType.ALL)
Shows show;
@ManyToOne(cascade=CascadeType.ALL)
Users userId;
@OneToMany(cascade=CascadeType.ALL)
List<BookingDetail> bookingDetails;

int active;

Date bookedDate;
Date showDate;
public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public Shows getShow() {
	return show;
}
public void setShow(Shows show) {
	this.show = show;
}
public Users getUserId() {
	return userId;
}
public void setUserId(Users userId) {
	this.userId = userId;
}
public List<BookingDetail> getBookingDetails() {
	return bookingDetails;
}
public void setBookingDetails(List<BookingDetail> bookingDetails) {
	this.bookingDetails = bookingDetails;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public Date getBookedDate() {
	return bookedDate;
}
public void setBookedDate(Date bookedDate) {
	this.bookedDate = bookedDate;
}
public Date getShowDate() {
	return showDate;
}
public void setShowDate(Date showDate) {
	this.showDate = showDate;
}
public Booking(Date bookedDate, Date showDate) {
	super();
	this.bookedDate = bookedDate;
	this.showDate = showDate;
}
public Booking(Shows show, Users userId, List<BookingDetail> bookingDetails, Date bookedDate,int active) {
super();

this.show = show;
this.userId = userId;
this.bookingDetails = bookingDetails;
this.bookedDate = bookedDate;
this.active=active;
}
public Booking( int active, Date bookedDate, Date showDate) {
	super();
	this.active = active;
	this.bookedDate = bookedDate;
	this.showDate = showDate;
}

}
