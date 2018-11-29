package com.yrenh.museumsmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AnnotationWebAppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) {
		System.out.println("startup()");
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebContextConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}
