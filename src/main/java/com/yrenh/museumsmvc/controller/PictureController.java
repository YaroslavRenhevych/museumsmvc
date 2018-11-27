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
import com.yrenh.museumsmvc.entity.Picture;
import com.yrenh.museumsmvc.service.PictureService;

@Controller
public class PictureController {
	@Autowired
	private PictureService painerService;
	
	@GetMapping("/pictures/create")
	public ModelAndView showPainterView() {
		return new ModelAndView("createPicture", "picture", new Picture());
	}
	
	@PostMapping("pictures/create")
	public ModelAndView createPainter(@ModelAttribute Picture picture,
			BindingResult result, ModelMap map) {
		this.painerService.create(picture);
		return new ModelAndView("createPicture", "picture", new Picture());
	}
}
