package com.paqui.openBankRestAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@RequestMapping("/hello")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to Open Bank Example.";
	}


}
