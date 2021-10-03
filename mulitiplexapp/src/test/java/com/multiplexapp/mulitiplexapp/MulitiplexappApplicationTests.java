package com.multiplexapp.mulitiplexapp;

import java.sql.Date;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.model.*;
import com.entities.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

@EnableTransactionManagement
@SpringBootTest
class MulitiplexappApplicationTests {

	@Autowired
	UsersService usersDAOImpl;
	@Autowired
	ShowsService showsDAOImpl;
	@Autowired
	MoviesService moviesDAOImpl;
	@Autowired
	HallService hallDAOImpl;
	@Autowired
	SeatTypeService seatTypeDAOImpl;
	@Autowired
	HallCapacityService hallCapacityDAOImpl;
    @Autowired
    BookingService bookingDAOImpl;
    @Autowired
    BookingDetailService bookingDetailImpl;

	@Test
	void contextLoads() {
	Users user=new Users("tulasi",'a',967619,"tulasi@gmail.com");
	usersDAOImpl.save(user);
	Users user1=usersDAOImpl.find(user.getUserId());
	assertThat("tulasi").isEqualTo(user1.getUserName());
	}
	@Test
	void contextLoads1() {
	Movies movie=new Movies( "xyz");
	moviesDAOImpl.save(movie);
	Movies movie1=moviesDAOImpl.find(movie.getMovieId());
	assertThat("xyz").isEqualTo(movie.getMovieName());
	}
	@Test
	void contextLoads2() {
	Hall hall=new Hall("hall10",100);
	hallDAOImpl.save(hall);
	Hall hall2=new Hall();
	hall2.setHallDesc("hall9");
	hall2.setTotalCapacity(100);
	hallDAOImpl.save(hall2);
	Hall hall1=hallDAOImpl.find(hall.getHallId());
	assertThat(hall.getTotalCapacity()).isEqualTo(hall2.getTotalCapacity());
	assertThat("hall10").isEqualTo(hall1.getHallDesc());
	List<Hall> showlist2=hallDAOImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	}
	@Test
	void contextLoad3() {
	Hall hall1=new Hall("hall101",101);
	Shows s1=new Shows();
	List<Shows> sl=new ArrayList<Shows>();
	sl.add(s1);
	showsDAOImpl.save(s1);
	HallCapacity hc=new HallCapacity();
	List<HallCapacity> hcl=new ArrayList<HallCapacity>();
	hcl.add(hc);
	hallCapacityDAOImpl.save(hc);
	hall1.setHallCapacity(hcl);
	hall1.setShows(sl);
	
	hallDAOImpl.save(hall1);
	assertThat(false).isEqualTo(hall1.getHallCapacity() instanceof HallCapacity);
	assertThat(false).isEqualTo(hall1.getShows() instanceof Shows);
	SeatType seatType=new SeatType("normal",100);
	seatTypeDAOImpl.save(seatType);
	HallCapacity hallCapacity=new HallCapacity(hall1,seatType,10);
	hallCapacityDAOImpl.save(hallCapacity);
	assertThat(10).isEqualTo(hallCapacity.getSeatCount());
	Shows s2=new Shows();
	List<Shows> sl1=new ArrayList<Shows>();
	sl1.add(s2);
	showsDAOImpl.save(s2);
	HallCapacity hc2=new HallCapacity();
	List<HallCapacity> hcl1=new ArrayList<HallCapacity>();
	hcl1.add(hc2);
	Hall h2=new Hall(sl1,hcl1,"hall2",123);

	

	}
	@Test
	void contextLoads4() {
	SeatType seatType=new SeatType("gold",200);
	HallCapacity h=new HallCapacity();
	List<HallCapacity> list=new ArrayList<HallCapacity>();
	list.add(h);
	BookingDetail bd=new BookingDetail();
	List<BookingDetail> listbd=new ArrayList<BookingDetail>();
	listbd.add(bd);
	seatType.setBookingDetail(listbd);
	seatType.setHallCapacity(list);
	Users user3=new Users("lxmn",'a',967619,"lxmn@gmail.com");
	usersDAOImpl.save(user3);
	seatTypeDAOImpl.save(seatType);
	assertThat(seatType.getBookingDetail().size()).isGreaterThan(0);
	assertThat(seatType.getHallCapacity().size()).isGreaterThan(0);
	SeatType seatType2=new SeatType();
	seatType2.setSeatTypeDesc("gold");
	seatType2.setSeatFare(200);
	seatTypeDAOImpl.save(seatType2);
	assertThat(seatType2.getSeatFare()).isEqualTo(seatType.getSeatFare());
	SeatType seatType1=seatTypeDAOImpl.find(seatType.getSeatTypeId());
	assertThat("gold").isEqualTo(seatType1.getSeatTypeDesc());
	List<SeatType> showlist2=seatTypeDAOImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	HallCapacity h1=new HallCapacity();
		List<HallCapacity> list2=new ArrayList<HallCapacity>();
		list.add(h1);
		BookingDetail bd1=new BookingDetail();
		List<BookingDetail> listbd2=new ArrayList<BookingDetail>();
		listbd2.add(bd1);
SeatType st=new SeatType("platinum",124,list2,listbd2);
seatTypeDAOImpl.save(st);
	}

	@Test
	void BookingTest() {
	Date d1=Date.valueOf("2021-09-08");
	Date d2=Date.valueOf("2021-09-09");
	Booking booking=new Booking(d1,d2);
	bookingDAOImpl.save(booking);
	SeatType s=new SeatType("gold",12);
	seatTypeDAOImpl.save(s);
	BookingDetail bd=bookingDAOImpl.booking(booking,6,s);
	bookingDetailImpl.save(bd);
	Booking booking2=bookingDAOImpl.deleteBooking(76, 1);
	//bookingDAOImpl.save(booking2);
	Booking booking3=bookingDAOImpl.find(booking.getBookingId());
	assertThat(1).isEqualTo(booking3.getActive());
	Booking booking1=bookingDAOImpl.find(booking.getBookingId());
	assertThat(d1).isEqualTo(booking1.getBookedDate());
	assertThat(d2).isEqualTo(booking1.getShowDate());
	List<Booking> showlist2=bookingDAOImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	Shows s1=new Shows();
	showsDAOImpl.save(s1);
	Booking b3=new Booking();
	b3.setShow(s1);
	BookingDetail bd1=new BookingDetail();
	bookingDetailImpl.save(bd1);
	List<BookingDetail> l1=new ArrayList<BookingDetail>();
	l1.add(bd1);
	b3.setBookingDetails(l1);
	bookingDAOImpl.save(b3);
    assertThat(b3.getBookingDetails().size()).isGreaterThan(0);
	assertThat(false).isEqualTo(b3.getUserId() instanceof Users);
	assertThat(true).isEqualTo(b3.getShow() instanceof Shows);
	BookingDetail bd2=new BookingDetail();
	bookingDetailImpl.save(bd2);
	List<BookingDetail> l2=new ArrayList<BookingDetail>();
	l2.add(bd2);
	Shows s5=new Shows();
	showsDAOImpl.save(s5);
	Users u2=new Users("tulasi",'a',967619,"tulasi@gmail.com");
	usersDAOImpl.save(u2);
	//Booking b6=new Booking(s5,u2,l2,d2,5);
	//bookingDAOImpl.save(b6);
	
	}
	@Test
	void contextLoads6() {
	HallCapacity hallCapacity=new HallCapacity(10);
	Hall hall=new Hall();
	hallDAOImpl.save(hall);
	hallCapacity.setHall(hall);
	SeatType seattype=new SeatType();
	seatTypeDAOImpl.save(seattype);
	hallCapacity.setSeatType(seattype);
	hallCapacity.setSeatCount(54);
	hallCapacityDAOImpl.save(hallCapacity);
	assertThat(hallCapacity.getHallCapacityId()).isGreaterThan(0);
	assertThat(true).isEqualTo(hallCapacity.getSeatType() instanceof SeatType);
	assertThat(true).isEqualTo(hallCapacity.getHall() instanceof Hall);
	assertThat(54).isEqualTo(hallCapacity.getSeatCount());
	
	List<HallCapacity> showlist2=hallCapacityDAOImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	HallCapacity bd2=hallCapacityDAOImpl.find(71);
	assertThat(10).isEqualTo(bd2.getSeatCount());

	}

	@Test
	void contextLoads7() {
	String d1="2021-09-09";
	String d2="2021-09-12";
	Date date2=Date.valueOf(d2);
	Date date=Date.valueOf(d1);
	Shows s=new Shows(27,date,date2);
	showsDAOImpl.save(s);
	Shows s2=showsDAOImpl.find(s.getShowId());
	assertThat(27).isEqualTo(s2.getSlotNo());
	}
	@Test
	void contextLoads8() {
	Users user=new Users("lxmn",'a',967619,"lxmn@gmail.com");
	usersDAOImpl.save(user);
	Users user1=new Users();
	user1.setUserName("tulasi");
	user1.setUserType('b');
	user1.setMobileNo(4567);
	user1.setEmailId("tulasi@gmail.com");
	usersDAOImpl.save(user1);
	Users user2=new Users("kavya",'a',967619,"lxmn@gmail.com");
	usersDAOImpl.save(user2);
	assertThat("tulasi@gmail.com").isEqualTo(user1.getEmailId());
	assertThat("tulasi").isEqualTo(user1.getUserName());
	assertThat('b').isEqualTo(user1.getUserType());
	assertThat(4567).isEqualTo(user1.getMobileNo());
	assertThat(true).isEqualTo(usersDAOImpl.update(user2));
	List<Users> showlist2=usersDAOImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	}
	@Test
	void contextLoads9() {
		
		Users user=new Users("lxmn",'a',967619,"lxmn@gmail.com");
		Users user2=new Users("lxmn",'a',967619,"lxmn@gmail.com");
		Booking b1=new Booking();
		bookingDAOImpl.save(b1);
		List<Booking> list=new ArrayList<Booking>();
		list.add(b1);
		user.setBooking(list);
		usersDAOImpl.save(user);
		assertThat(user.getBooking().size()).isGreaterThan(0);
		Users user1=usersDAOImpl.find(user.getUserId());
		assertThat("lxmn").isEqualTo(user1.getUserName());
		assertThat("New User Saved").isEqualTo(usersDAOImpl.validateUser(user2));
		Booking b2=new Booking();
		bookingDAOImpl.save(b2);
		List<Booking> list2=new ArrayList<Booking>();
		list2.add(b2);
		Users user3=new Users("lxmn",'a',967619,"lxmn@gmail.com",list2);
		usersDAOImpl.save(user3);
		}
	@Test
	void contextLoads10() {
		BookingDetail bd=new BookingDetail();
		Booking b1=new Booking();
		bookingDAOImpl.save(b1);
		SeatType st=new SeatType();
		seatTypeDAOImpl.save(st);
		bd.setNoOfSeats(20);
		bookingDetailImpl.save(bd);
		assertThat(bd.getBookingDetailId()).isGreaterThan(0);
		assertThat(false).isEqualTo(bd.getBooking() instanceof Booking);
		assertThat(false).isEqualTo(bd.getSeatType() instanceof SeatType);
		BookingDetail bd1=new BookingDetail(20);
		bookingDetailImpl.save(bd1);
		assertThat(bd.getNoOfSeats()).isEqualTo(bd1.getNoOfSeats());
		
		Booking b2=new Booking();
		bookingDAOImpl.save(b2);
		SeatType st2=new SeatType();
		seatTypeDAOImpl.save(st2);
		BookingDetail bd2=new BookingDetail(b2,st2,7);

	}
	@Test
	void contextLoads11() {
	Booking b=new Booking();
	String d1="2021-09-09";
	String d2="2021-09-12";
	Date date2=Date.valueOf(d2);
	Date date=Date.valueOf(d1);
	b.setActive(1);
	b.setBookedDate(date);
	b.setShowDate(date2);
	bookingDAOImpl.save(b);
	Booking b1=new Booking(0,date,date2);
	bookingDAOImpl.save(b1);
	SeatType seatType3=new SeatType();
	seatType3.setSeatTypeDesc("gold");
	seatType3.setSeatFare(200);
	seatTypeDAOImpl.save(seatType3);
	BookingDetail bdt=new BookingDetail();
	bdt.setBooking(b);
	bdt.setSeatType(seatType3);
	bdt.setNoOfSeats(20);
	bookingDetailImpl.save(bdt);
	assertThat(1).isEqualTo(b.getActive());
	List<BookingDetail> showlist2=bookingDetailImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	BookingDetail bd2=bookingDetailImpl.find(78);
	assertThat(6).isEqualTo(bd2.getNoOfSeats());
	}
	@Test
	void contextLoads12() {
	Movies m=new Movies("hello");
	m.setMovieName("xyz");
	moviesDAOImpl.save(m);
	Hall h=new Hall();
	h.setHallDesc("hall9");
	h.setTotalCapacity(100);
	hallDAOImpl.save(h);
	Movies movies=moviesDAOImpl.QueryMovies(m.getMovieName(), h.getHallId());
   Movies movie=moviesDAOImpl.find(m.getMovieId());
   Movies movie2=moviesDAOImpl.find(2);
   assertThat(false).isEqualTo(movie2 instanceof Movies); 
	assertThat("xyz").isEqualTo(m.getMovieName());
	assertThat("hall9").isEqualTo(h.getHallDesc());
	List<Movies> showlist2=moviesDAOImpl.getAll();
	assertThat(showlist2.size()).isGreaterThan(0);
	List<Shows> list=new ArrayList<Shows>();
	Shows s1=new Shows();
	Shows s2=new Shows();
	showsDAOImpl.save(s2);
	showsDAOImpl.save(s1);
	list.add(s2);
	list.add(s1);
	m.setShows(list);
	assertThat(m.getShows().size()).isGreaterThan(0);
	}
	@Test
	void contextLoads13() {
		Hall hall=new Hall("hall600",600);
		hallDAOImpl.save(hall);
		List<Shows> showlist=new ArrayList<Shows>();
		List<Booking> bookinglist=new ArrayList<Booking>();
		Booking b1=new Booking();
		bookingDAOImpl.save(b1);
		Booking b2=new Booking();
		bookingDAOImpl.save(b2);
		String d1="2021-09-09";
		String d2="2021-09-12";
		Date date2=Date.valueOf(d2);
		Date date=Date.valueOf(d1);
		b1.setBookedDate(date);
		b2.setBookedDate(date);
		bookinglist.add(b1);
		bookinglist.add(b2);
		
		Shows s=new Shows(12,date,date2);
		showsDAOImpl.save(s);
		showlist.add(s);
		Movies movie=new Movies(showlist,"svsc");
		moviesDAOImpl.save(movie);
		Shows s2=showsDAOImpl.find(s.getShowId());
		Shows s3=new Shows(hall,movie,bookinglist,4,date2,date);
		showsDAOImpl.save(s3);
		assertThat(date2).isEqualTo(s3.getFromDate());
		assertThat(12).isEqualTo(s.getSlotNo());
		assertThat(date2).isEqualTo(s2.getToDate());
		assertThat(date).isEqualTo(s2.getFromDate());
		List<Booking> bookinglist2=new ArrayList<Booking>();
		Booking b3=new Booking();
		bookinglist2.add(b3);
		Shows s4=new Shows();
		s4.setBooking(bookinglist2);
		s4.setFromDate(date);
		s4.setToDate(date);
		s4.setHall(hall);
		s4.setMovies(movie);
		s4.setSlotNo(9);
		showsDAOImpl.save(s4);
		assertThat(hall.toString()).isEqualTo(s4.getHall().toString());
		assertThat(movie.toString()).isEqualTo(s4.getMovies().toString());
		assertThat(bookinglist2).isEqualTo(s4.getBooking());
		List<Shows> showlist2=showsDAOImpl.getAll();
		assertThat(showlist2.size()).isGreaterThan(0);
		
		Shows test=showsDAOImpl.find(65);
		assertThat(9).isEqualTo(test.getSlotNo());
		
	}
	
}
