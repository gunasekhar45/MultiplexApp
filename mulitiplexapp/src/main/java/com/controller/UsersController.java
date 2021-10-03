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
import com.model.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/users")
@Api(value = "Users", description = "Users Registration")
public class UsersController {

@Autowired
UsersService usersService;

@GetMapping("/getusers")
@ApiOperation(value = "Get  All Users ", httpMethod = "GET")

public ResponseEntity<?> getAllUsers()
{
	List<Users> userslist=usersService.getAll();
	return new ResponseEntity(userslist,HttpStatus.OK);
}

@PostMapping("/saveusers")
@ApiOperation(value = "Save users", httpMethod = "POST")
public ResponseEntity<?> saveUsers(Users users)
{
	usersService.save(users);
 return ResponseEntity.ok(users+" saved");
}


@PostMapping("/updateusers")
@ApiOperation(value="Update users",httpMethod="POST")
public ResponseEntity<?> updateUsers(Users users)
{
if(usersService.update(users))
{
	 return ResponseEntity.ok(users+"user updated");
}
else
{
	return new ResponseEntity("not updated ",HttpStatus.BAD_REQUEST);
}

}

@PostMapping("/validateusers")
@ApiOperation(value = "Validate users", httpMethod = "POST")
public ResponseEntity<?> validateUsers(Users users)
{
	String test=usersService.validateUser(users);
	if(test.equals("Valid User"))
 return ResponseEntity.ok("validated");
	else
		return ResponseEntity.ok("New User Created");
}



}