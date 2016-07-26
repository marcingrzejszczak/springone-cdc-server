package com.example;

import org.junit.Before;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

public class BaseTest {

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new ProducerController());
	}
	
}
