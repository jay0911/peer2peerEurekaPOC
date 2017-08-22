package com.poc.feignclients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poc.models.User;

@FeignClient(name = "CLIENT2")
public interface PocFeign {
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String hello();
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
	public ResponseEntity<String> process(@RequestBody User user);
}
