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
	private static final String GET_CREATE_PAINTER_VIEW = "/pictures/create";
	private static final String MUSEUM_LIST_ATTRIBUTE_NAME = "museumList";
	private static final String PAINTER_LIST_ATTRIBUTE_NAME = "painterList";
	private static final String CREATE_PICTURE_VIEW_NAME = "createPicture";
	private static final String PICTURE_MODEL_NAME = "picture";
	private static final String POST_PAINTER_URL = "pictures/create";
	private static final String POST_PAINTER_REDIRECT_URL = "redirect:/app/pictures/create";

	@GetMapping(GET_CREATE_PAINTER_VIEW)
	public ModelAndView showPainterView(final ModelMap map) {
		map.addAttribute(MUSEUM_LIST_ATTRIBUTE_NAME, museumService.getAll());
		map.addAttribute(PAINTER_LIST_ATTRIBUTE_NAME, painterService.getAll());
		return new ModelAndView(CREATE_PICTURE_VIEW_NAME, PICTURE_MODEL_NAME, new Picture());
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(POST_PAINTER_URL)
	public ModelAndView createPainter(@ModelAttribute(PICTURE_MODEL_NAME) final Picture picture, final BindingResult result,
			final ModelMap map) {
		this.painerService.create(picture);
		return new ModelAndView(POST_PAINTER_REDIRECT_URL, PICTURE_MODEL_NAME, new Picture());
	}
}
