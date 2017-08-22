package com.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.models.User;

@RestController
public class ClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@GetMapping("/hello")
	public String hello(){
		return "hello world";
	}
	
	@PostMapping("/process")
	public ResponseEntity<String> process(@RequestBody User user) {
		logInfo("----client2 entering----"+user.toString()+"---------");
		return new ResponseEntity<String>("ok", new HttpHeaders(), HttpStatus.OK);
	}
	
	private static void logInfo(String msg){
		if(LOGGER.isInfoEnabled()){
			LOGGER.info(msg);
		}
	}
}
