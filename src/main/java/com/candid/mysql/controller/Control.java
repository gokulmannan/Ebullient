package com.candid.mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class Control {
	
	@GetMapping("/hi")
	public String hi()
	{
		return "hello";
	}

}
