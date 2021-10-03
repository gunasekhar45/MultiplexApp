package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.entities.*;
import com.model.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/bookingdetail")
@Api(value = "BookingDetailController", description = "Description for Booking Detail Controller")
public class BookingDetailController {

@Autowired
BookingDetailService bookingDetailService;


@GetMapping("/getBoookingdetails")
@ApiOperation(value = "Get  All BookingDetails ", httpMethod = "GET")

public ResponseEntity<?> getAllBookingDetails()
{
	List<BookingDetail> bookingsDetaillist=bookingDetailService.getAll();
	return new ResponseEntity(bookingsDetaillist,HttpStatus.OK);
}

@PostMapping("/savebookingdetails")
@ApiOperation(value = "Save bookingDetails", httpMethod = "POST")
public ResponseEntity<?> saveBookingetails(BookingDetail bookingdetails)
{
	bookingDetailService.save(bookingdetails);
 return ResponseEntity.ok(bookingdetails+" saved");
}

}