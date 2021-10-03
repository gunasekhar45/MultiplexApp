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
@RequestMapping("/shows")
@Api(value = "ShowssController", description = "Description for Showss Controller")
public class ShowsController {



@Autowired
ShowsService showsService;

@GetMapping("/getShows")
@ApiOperation(value = "Get All Shows ", httpMethod = "GET")

public ResponseEntity<?> getAllShows()
{
List<Shows> showslist=showsService.getAll();
return new ResponseEntity(showslist,HttpStatus.OK);
}
@PostMapping("/GetShowDetails")
@ApiOperation(value = "Get show", httpMethod = "POST")
public ResponseEntity<?> GetShow(Shows shows)
{
Shows show1=showsService.find(shows.getShowId());
return new ResponseEntity(show1,HttpStatus.OK);
}

@PostMapping("/saveshows")
@ApiOperation(value = "Save shows", httpMethod = "POST")
public ResponseEntity<?> saveShows(Shows shows)
{
showsService.save(shows);
return ResponseEntity.ok(shows+" saved");
}



}