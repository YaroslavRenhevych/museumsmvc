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
		System.out.println("hello1");
		return "createVisitor";
	}
	
	@RequestMapping(value = "/")
	public String hello2() {
		System.out.println("hello2");
		return "createVisitor";
	}
	
	@RequestMapping(value = "")
	public String hello3() {
		System.out.println("hello3");
		return "createVisitor";
	}
	
	@GetMapping("/visitors/create")
	public String createVisitorView() {
		System.out.println("create visitor");
		return "createVisitor";
	}
}
