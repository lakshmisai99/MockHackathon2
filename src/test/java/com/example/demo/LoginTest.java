package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ing.domain.BankInfo;
import com.ing.domain.CustomerInfo;


public class LoginTest extends AbstractTest  {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	
	@Test
	public void login() throws Exception {
		String uri = "/api/login";
		CustomerInfo review = new CustomerInfo(18592,"test","customer");

		String inputJson = super.mapToJson(review);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		//System.out.println(mvcResult.getResponse().getStatus());
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		CustomerInfo customerInfo = super.mapFromJson(content, CustomerInfo.class);
		assertNotNull(customerInfo);
	}
	
	
	@Test
	public void createAccount() throws Exception {
		String uri = "/api/createAccount";
		CustomerInfo review = new CustomerInfo("Test","test","ERBSR68D","213456371283","Female","sur@gmail.com","968425974","customer");
		
		String inputJson = super.mapToJson(review);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		//System.out.println(mvcResult.getResponse().getStatus());
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		BankInfo bank = super.mapFromJson(content, BankInfo.class);
		assertNotNull(bank);
	}
	
}
