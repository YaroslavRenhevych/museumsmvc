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

import com.yrenh.museumsmvc.entity.Visitor;
import com.yrenh.museumsmvc.service.MuseumService;
import com.yrenh.museumsmvc.service.VisitorService;

@Controller
public class VisitorController {

	@Autowired
	private VisitorService visitorService;
	@Autowired
	private MuseumService museumService;
	private static final String GET_CREATE_VISITOR_URL = "/visitors/create";
	private static final String POST_VISITOR_URL = "/visitors/create";
	private static final String POST_VISITOR_REDIRECT_URL = "redirect:/app/visitors/create";
	private static final String MUSEUM_LIST_ATTRIBUTE_NAME = "museumList";
	private static final String VISITOR_MODEL_NAME = "visitor";

	@GetMapping(GET_CREATE_VISITOR_URL)
	public ModelAndView showCreateVisitorView(ModelMap map) {
		map.addAttribute(MUSEUM_LIST_ATTRIBUTE_NAME, museumService.getAll());
		Visitor visitor = new Visitor();
		return new ModelAndView("createVisitor", "visitor", visitor);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(POST_VISITOR_URL)
	public ModelAndView createVisitor(@ModelAttribute Visitor visitor, BindingResult result, ModelMap map) {
		visitorService.create(visitor);
		return new ModelAndView(POST_VISITOR_REDIRECT_URL, VISITOR_MODEL_NAME, new Visitor());
	}
}
