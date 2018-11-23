package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yrenh.museumsmvc.service.PictureService;

@Controller
public class PictureController {
	@Autowired
	private PictureService painerService;
	
	@GetMapping("/painters/create")
	public String painterServiceView() {
		return "createPainter";
	}
}
