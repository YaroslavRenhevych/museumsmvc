package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yrenh.museumsmvc.service.MuseumService;

@Controller
public class MuseumController {
	@Autowired
	private MuseumService museumServie;
	
	@GetMapping("/museums/create")
	public String createMuseumView() {
		return "createMuseum";
	}
}
