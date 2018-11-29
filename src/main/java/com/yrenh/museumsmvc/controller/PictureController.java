package com.yrenh.museumsmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yrenh.museumsmvc.entity.Picture;
import com.yrenh.museumsmvc.service.MuseumService;
import com.yrenh.museumsmvc.service.PainterService;
import com.yrenh.museumsmvc.service.PictureService;

@Controller
public class PictureController {
	@Autowired
	private PictureService painerService;
	@Autowired
	private MuseumService museumService;
	@Autowired
	private PainterService painterService;
	
	@GetMapping("/pictures/create")
	public ModelAndView showPainterView(ModelMap map) {
		map.addAttribute("museumList", museumService.getAll());
		map.addAttribute("painterList", painterService.getAll());
		return new ModelAndView("createPicture", "picture", new Picture());
	}
	
	@PostMapping("pictures/create")
	public ModelAndView createPainter(@ModelAttribute("picture") Picture picture,
			BindingResult result, ModelMap map) {
		this.painerService.create(picture);
		return new ModelAndView("redirect:/app/pictures/create", "picture", new Picture());
	}
}
