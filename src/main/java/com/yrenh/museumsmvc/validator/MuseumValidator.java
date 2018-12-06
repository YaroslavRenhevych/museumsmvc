package com.yrenh.museumsmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yrenh.museumsmvc.entity.Museum;

public class MuseumValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Museum.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Museum museum = (Museum) target;
		if(museum.getTitle() == null || museum.getTitle().equals("")) {
			ValidationUtils.rejectIfEmpty(errors, "title", "","Enter a valid title");
		}
		if(museum.getAddress() == null || museum.getAddress().equals("")) {
			ValidationUtils.rejectIfEmpty(errors, "address", "","Enter a valid address");
		}
		if(museum.getPhone() == null || museum.getPhone().equals("")) {
			ValidationUtils.rejectIfEmpty(errors, "phone", "","Enter a valid phone");
		}
		if(museum.getSite() == null || museum.getSite().equals("")) {
			ValidationUtils.rejectIfEmpty(errors, "site", "","Enter a valid site");
		}
		if(museum.getFoundingDate() == null) {
			ValidationUtils.rejectIfEmpty(errors, "foundingDate", "","Enter a valid date");
		}
	}

	
}
