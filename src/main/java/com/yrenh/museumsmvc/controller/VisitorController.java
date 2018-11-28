package com.yrenh.museumsmvc.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yrenh.museumsmvc.entity.Museum;
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
		visitor.setMuseums(new ArrayList<Museum>());
		return new ModelAndView("createVisitor", "visitor", visitor);
	}
	
	@PostMapping("/visitors/create")
	public ModelAndView createVisitor(@ModelAttribute Visitor visitor,
			BindingResult result, ModelMap map, Date birthDate) {
		System.out.println("argument date: "+birthDate);
		System.out.println("date: "+visitor.getBirthDate());
		System.out.println("museums: "+visitor.getMuseums());
		visitorService.create(visitor);
		return new ModelAndView("redirect:/app/visitors/create", "visitor", new Visitor());
	}
	/*@InitBinder 
	public void dataBinding(WebDataBinder binder) { 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
	    CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true); 
	    binder.registerCustomEditor(LocalDate.class, dateEditor); 
	}*/
}
