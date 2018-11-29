package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yrenh.museumsmvc.entity.Painter;
import com.yrenh.museumsmvc.service.PainterService;

@Controller
public class PainterController {
	@Autowired
	private PainterService painterService;
	
	@GetMapping("/painters/create")
	public ModelAndView showPainterView() {
		return new ModelAndView("createPainter", "painter", new Painter());
	}
	
	@PostMapping("/painters/create")
	public ModelAndView createPainter(@ModelAttribute Painter painter, 
			BindingResult result, ModelMap modelMap) {
		painterService.create(painter);
		return new ModelAndView("redirect:/app/painters/create", "painter", new Painter());
	}
}
