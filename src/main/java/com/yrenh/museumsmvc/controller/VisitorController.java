package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yrenh.museumsmvc.entity.Visitor;
import com.yrenh.museumsmvc.service.VisitorService;

@Controller
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;
	
	@GetMapping("/visitors/create")
	public ModelAndView showCreateVisitorView() {
		return new ModelAndView("createVisitor", "visitor", new Visitor());
	}
	
	@PostMapping("/visitors/create")
	public ModelAndView createVisitor(@ModelAttribute Visitor visitor,
			BindingResult result, ModelMap map) {
		visitorService.create(visitor);
		return new ModelAndView("createVisitor", "visitor", new Visitor());
	}
}
