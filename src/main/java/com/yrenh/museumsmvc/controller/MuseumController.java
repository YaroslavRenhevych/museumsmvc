package com.yrenh.museumsmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.yrenh.museumsmvc.entity.Museum;
import com.yrenh.museumsmvc.service.MuseumService;
import com.yrenh.museumsmvc.validator.MuseumValidator;

@Controller
public class MuseumController {
	@Autowired
	private MuseumService museumServie;
	private static final String CREATE_MUSEUM_VIEW_NAME = "createMuseum";
	private static final String MUSEUM_MODEL_NAME = "museum";
	private static final String GET_MUSEUM_CREATE_VIEW_URL = "/museums/create";
	private static final String POST_MUSEUM_URL = "/museums/create";
	private static final String POST_MUSEUM_REDIRECT_URL = "redirect:/app/museums/create";

	@GetMapping("/museums/create")
	public ModelAndView showMuseumView(ModelMap model) {
		return new ModelAndView(CREATE_MUSEUM_VIEW_NAME, MUSEUM_MODEL_NAME, new Museum());
	}

	@PostMapping("/museums/create")
	public String createMuseum(@Validated @ModelAttribute(MUSEUM_MODEL_NAME) final Museum museum, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return CREATE_MUSEUM_VIEW_NAME;
		}
		this.museumServie.create(museum);
		redirectAttributes.addFlashAttribute("success_message", "Museum was successfylly created!");
		return "redirect:/app/museums/create";
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new MuseumValidator());
	}
}
