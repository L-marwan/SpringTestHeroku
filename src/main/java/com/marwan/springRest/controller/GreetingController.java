package com.marwan.springRest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marwan.springRest.model.Greeting;

@RestController
public class GreetingController {
	private static final String templat="Hello %";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World")String name){
		return new Greeting(counter.incrementAndGet(), String.format(templat, name));
	}
}
