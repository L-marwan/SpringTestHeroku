package com.marwan.springRest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marwan.springRest.model.Greeting;

@RestController
public class GreetingController {
	
	private Logger logger = LoggerFactory.getLogger(GreetingController.class);

	
	private static final String templat="Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World")String name){
		logger.info(">>>greeting controller greeting()");
		return new Greeting(counter.incrementAndGet(), String.format(templat, name));
	}
}
