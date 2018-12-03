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

import com.yrenh.museumsmvc.entity.Painter;
import com.yrenh.museumsmvc.service.PainterService;

@Controller
public class PainterController {
	@Autowired
	private PainterService painterService;
	private static final String CREATE_PAINTER_VIEW_URL = "/painters/create";
	private static final String CREATE_PAINTER_VIEW_NAME = "createPainter";
	private static final String PAINTER_MODEL_NAME = "painter";
	private static final String POST_PAINTER_URL = "/painters/create";
	private static final String POST_PAINTER_REDIRECT_URL = "redirect:/app/painters/create";

	@GetMapping(CREATE_PAINTER_VIEW_URL)
	public ModelAndView showPainterView() {
		return new ModelAndView(CREATE_PAINTER_VIEW_NAME, PAINTER_MODEL_NAME, new Painter());
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(POST_PAINTER_URL)
	public ModelAndView createPainter(@ModelAttribute Painter painter, BindingResult result, ModelMap modelMap) {
		painterService.create(painter);
		return new ModelAndView(POST_PAINTER_REDIRECT_URL, PAINTER_MODEL_NAME, new Painter());
	}
}
