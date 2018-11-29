package com.yrenh.museumsmvc.controller;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/visitors/create")
	public ModelAndView showCreateVisitorView(ModelMap map) {
		map.addAttribute("museumList", museumService.getAll());
		Visitor visitor = new Visitor();
		return new ModelAndView("createVisitor", "visitor", visitor);
	}
	
	@PostMapping("/visitors/create")
	public ModelAndView createVisitor(@ModelAttribute Visitor visitor,
			BindingResult result, ModelMap map) {
		visitorService.create(visitor);
		System.out.println("museums: "+visitor.getMuseums());
		return new ModelAndView("redirect:/app/visitors/create", "visitor", new Visitor());
	}
}
