package com.yrenh.museumsmvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.yrenh.museumsmvc.controller")
public class WebContextConfig {
	private static final String PREFIX = "/WEB-INF/view/";
	private static final String SUFFIX = ".jsp";

	@Bean
	public ViewResolver viewResoler() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(PREFIX);
		resolver.setSuffix(SUFFIX);
		return resolver;
	}
	/*@Bean
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }*/
}
