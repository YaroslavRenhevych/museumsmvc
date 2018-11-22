package com.yrenh.museumsmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.yrenh.museumsmvc.controller")
public class WebContextConfig {
	
	@Bean
	ViewResolver viewResoler() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/view");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
