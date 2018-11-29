package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yrenh.museumsmvc.entity.Museum;
import com.yrenh.museumsmvc.service.MuseumService;

@Controller
public class MuseumController {
	@Autowired
	private MuseumService museumServie;
	
	@GetMapping("/museums/create")
	public ModelAndView showMuseumView() {
		return new ModelAndView("createMuseum","museum", new Museum());
	}
	
	@PostMapping("/museums/create")
	public ModelAndView createMuseum(@ModelAttribute("museum")Museum museum,
		BindingResult result, ModelMap model) {
		this.museumServie.create(museum);
		return new ModelAndView("redirect:/app/museums/create", "museum", new Museum());
	}
}
