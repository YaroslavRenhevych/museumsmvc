package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yrenh.museumsmvc.service.PainterService;

@Controller
public class PainterController {
	@Autowired
	private PainterService painterService;
	
	@GetMapping("/painters/create")
	public String createPainterView() {
		return "createPainter";
	}
}
