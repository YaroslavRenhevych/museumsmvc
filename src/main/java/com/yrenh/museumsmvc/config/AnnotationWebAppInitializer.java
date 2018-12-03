package com.yrenh.museumsmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AnnotationWebAppInitializer implements WebApplicationInitializer {

	private static final String SERVLET_NAME = "app";
	private static final String SERVLET_MAPPING = "/app/*";
	private static final int SERVLET_LOADING_PRIORITY = 1;

	@Override
	public final void onStartup(final ServletContext servletContext) {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebContextConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		ServletRegistration.Dynamic registration = servletContext.addServlet(SERVLET_NAME, dispatcherServlet);
		registration.setLoadOnStartup(SERVLET_LOADING_PRIORITY);
		registration.addMapping(SERVLET_MAPPING);

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}
