package com.yrenh.museumsmvc.test.integration;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yrenh.museumsmvc.config.RootContextConfig;
import com.yrenh.museumsmvc.config.WebContextConfig;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import museumsmvc.config.DataSourceConfig;

@ContextConfiguration(classes = { WebContextConfig.class, RootContextConfig.class, DataSourceConfig.class })
@WebAppConfiguration
public class GetCreatePainterPageStepDefs {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	private ResultActions actions;
	
	@Before
	public void before() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		ServletContext servletContext = wac.getServletContext();
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("painterController"));
	}
	
	@When("^the client calls \"(.*?)\" for painter creation$")
	public void the_client_issues_GET_version(String url) throws Throwable {
	    actions = mockMvc.perform(MockMvcRequestBuilders.get(url))
				.andDo(MockMvcResultHandlers.print());
    }
	
	@Then("^the client receives status code of (\\d+) from create pinter page$")
	public void the_client_receives_status_code_of(int statusCode) throws Exception {
		actions.andExpect(MockMvcResultMatchers.status().is(statusCode));
	}
	
	@And("^the client forwarded to url \"([^\"]*)\" to create painter page$")
	public void the_client_forwarded_to_url(String url) throws Exception {
		actions.andExpect(MockMvcResultMatchers.forwardedUrl(url));
	}
	
	@And("the client gets view with name \"(.*?)\" for create painter page")
	public void the_client_gets_view_with_name(String name) throws Exception {
		actions.andExpect(MockMvcResultMatchers.view().name(name));
	}
}
