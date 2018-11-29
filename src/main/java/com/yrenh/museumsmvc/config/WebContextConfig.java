package com.yrenh.museumsmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.yrenh.museumsmvc.converter.StringToLocalDateConverter;
@EnableWebMvc
@Configuration
@ComponentScan("com.yrenh.museumsmvc.controller")
public class WebContextConfig implements WebMvcConfigurer {
	
	/*@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("add formatter");
		registry.addConverter(new StringToLocalDateConverter());
	}*/
	
	@Bean
	ViewResolver viewResoler() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
