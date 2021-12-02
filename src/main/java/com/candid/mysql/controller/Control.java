package com.candid.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.candid.mysql.entity.MyStudent;
import com.candid.mysql.service.User;
import com.candid.mysql.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
 public class Control {
	@Autowired
	UserService service;
	
	@GetMapping("/hi")
	public String hi()
	{
		return "hello";
	}

	@PostMapping("/add")
	public ResponseEntity<MyStudent> add(@RequestBody MyStudent s)
	{
		MyStudent data=service.save(s);
		return new ResponseEntity<MyStudent>(data, HttpStatus.CREATED);
	}
}
