package com.yrenh.museumsmvc.test.integration;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.context.WebApplicationContext;

import com.yrenh.museumsmvc.config.RootContextConfig;
import com.yrenh.museumsmvc.config.WebContextConfig;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import museumsmvc.config.DataSourceConfig;

@ContextConfiguration(classes = { WebContextConfig.class, RootContextConfig.class, DataSourceConfig.class })
@WebAppConfiguration
public class CreatePainterStepDefs {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	private ResultActions actions;
	
	@Autowired
    private PlatformTransactionManager txMgr;
	
	private TransactionStatus txStatus;
	
	@Before
	public void before() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		ServletContext servletContext = wac.getServletContext();
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("painterController"));
		
		txStatus = txMgr.getTransaction(new DefaultTransactionDefinition());
		
	}
	@After
	public void after() {
		txMgr.rollback(txStatus);
	}
	
	@When("^the client sends data about painter to \"(.*?)\"$")
	public void the_client_sends_data(String url, DataTable params) throws Throwable {

	    List<Map<String, String>> table = params.asMaps(String.class, String.class);
	    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
	    table.forEach(map -> requestBuilder.param(map.get("KEY"), map.get("VALUE")));
	    actions = mockMvc.perform(requestBuilder)
				.andDo(MockMvcResultHandlers.print());

    }
	
	@Then("^the client gets status code of (\\d+) means that painter was created$")
	public void the_client_receives_status_code_of(int statusCode) throws Exception {
		actions.andExpect(MockMvcResultMatchers.status().is(statusCode));
	}
	
	@And("^the client redirected to url \"(.*?)\" for creating new painter$")
	public void the_client_redirected_to_url(String url) throws Exception {
		actions.andExpect(MockMvcResultMatchers.redirectedUrl(url));
	}
}
