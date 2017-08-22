package com.poc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import com.poc.service.Processor;

@RestController
public class ClientController {
	
	@Autowired
	@Qualifier("fileprocessor") 
	private Processor processor;

	@GetMapping("/hello")
	public String hello(){
		return "hello world";
	}
	
	@GetMapping("/process")
	public void process() {
		processor.process();
	}
	
}
