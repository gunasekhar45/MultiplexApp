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
@RequestMapping("/seattype")
@Api(value = "SeatTypeController", description = "Description for SeatType Controller")
public class SeatTypeController {

@Autowired
SeatTypeService seattypeService;


@GetMapping("/getSeatTypes")
@ApiOperation(value = "Get  All SeatTypes ", httpMethod = "GET")

public ResponseEntity<?> getAllSeatTypes()
{
	List<SeatType> seattypelist=seattypeService.getAll();
	return new ResponseEntity(seattypelist,HttpStatus.OK);
}

@PostMapping("/saveseattypes")
@ApiOperation(value = "Save seattypes", httpMethod = "POST")
public ResponseEntity<?> saveSeatTypes(SeatType seattype)
{
seattypeService.save(seattype);
 return ResponseEntity.ok(seattype+" saved");
}

}