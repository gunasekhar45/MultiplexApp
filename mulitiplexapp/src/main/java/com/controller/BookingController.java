package com.controller;
import java.sql.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.entities.*;
import com.model.*;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/booking")
@Api(value = "BookingController", description = "Description for Booking Controller")
public class BookingController {



@Autowired
BookingService bookingService;




@GetMapping("/getBoookings")
@ApiOperation(value = "Get All Bookings ", httpMethod = "GET")

public ResponseEntity<?> getAllBookings()
{
List<Booking> bookingslist=bookingService.getAll();
return new ResponseEntity(bookingslist,HttpStatus.OK);
}



@PostMapping("/savebookings")
@ApiOperation(value = "Save bookings", httpMethod = "POST")
public ResponseEntity<?> saveBookings( Booking bookings)
{
bookingService.save(bookings);
return ResponseEntity.ok(bookings+" saved");
}




@PostMapping("/deleteBooking")
@ApiOperation(value = "Delete bookings", httpMethod = "POST")
public ResponseEntity<?> deleteBookings(Booking bookings)
{
bookingService.deleteBooking(bookings.getBookingId(), bookings.getActive());
return ResponseEntity.ok(bookings+"Cancelled");
}




@PostMapping("/bookingmovie")
@ApiOperation(value = "booking movie", httpMethod = "POST")
public ResponseEntity<?> booking(Booking booking,int noOfSeats,SeatType seatType)
{
BookingDetail test=bookingService.booking(booking,noOfSeats,seatType);
return ResponseEntity.ok(test+"Booking confirmed");



}
}