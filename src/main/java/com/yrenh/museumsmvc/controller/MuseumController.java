package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.yrenh.museumsmvc.entity.Museum;
import com.yrenh.museumsmvc.service.MuseumService;

@Controller
public class MuseumController {
	@Autowired
	private MuseumService museumServie;
	private static final String CREATE_MUSEUM_VIEW_NAME = "createMuseum";
	private static final String MUSEUM_MODEL_NAME = "museum";
	private static final String GET_MUSEUM_CREATE_VIEW_URL = "/museums/create";
	private static final String POST_MUSEUM_URL = "/museums/create";
	private static final String POST_MUSEUM_REDIRECT_URL = "redirect:/app/museums/create";

	@GetMapping(GET_MUSEUM_CREATE_VIEW_URL)
	public ModelAndView showMuseumView() {
		return new ModelAndView(CREATE_MUSEUM_VIEW_NAME, MUSEUM_MODEL_NAME, new Museum());
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(POST_MUSEUM_URL)
	public ModelAndView createMuseum(@ModelAttribute(MUSEUM_MODEL_NAME) final Museum museum, BindingResult result,
			ModelMap model) {
		this.museumServie.create(museum);
		return new ModelAndView(POST_MUSEUM_REDIRECT_URL, MUSEUM_MODEL_NAME, new Museum());
	}
}
