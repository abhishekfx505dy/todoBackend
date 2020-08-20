package com.todo.todoBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoBackend.beans.HelloWorldBean;

//This project doesnt use Spring-Data-Rest yet.
// RestController is still available.

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	//Returning a simple string
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//Returning a Bean
	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World - Updated!!!");
	}
	
	//Returning Bean while accepting param from path variable.
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
