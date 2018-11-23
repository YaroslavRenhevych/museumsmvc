package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yrenh.museumsmvc.service.VisitorService;

@Controller
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService; 
	
	@RequestMapping(value = "/hello")
	public String hello() {
		System.out.println("hello");
		return "createVisitor";
	}
	
	@RequestMapping(value = "/")
	public String hello2() {
		System.out.println("hello");
		return "createVisitor";
	}
	
	@RequestMapping(value = "")
	public String hello3() {
		System.out.println("hello");
		return "createVisitor";
	}
	
	@GetMapping("/visitors/create")
	public String createVisitorView() {
		return "createVisitor";
	}
}
