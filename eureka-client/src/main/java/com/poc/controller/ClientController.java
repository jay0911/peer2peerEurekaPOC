package com.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.feignclients.PocFeign;
import com.poc.models.User;
import com.poc.service.Processor;

@RestController
public class ClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private PocFeign feignClient;
	
	@Autowired
	@Qualifier("fileprocessor") 
	private Processor processor;

	@GetMapping("/hello")
	public String hello(){
		logInfo("-----Expecting request-------");
		return feignClient.hello();
	}
	
	@GetMapping("/process")
	public void process() {
		processor.process();
	}

	@PostMapping("/processUser")
	public void process(@RequestBody User user) {
		processor.process(user);
	}
	
	private static void logInfo(String msg){
		if(LOGGER.isInfoEnabled()){
			LOGGER.info(msg);
		}
	}
}
