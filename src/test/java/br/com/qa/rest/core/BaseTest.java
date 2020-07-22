package br.com.qa.rest.core;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constantes {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.port = APP_PORT;
		RestAssured.basePath = APP_BASE_PATH;
		
		RequestSpecBuilder reqbuilder =  new  RequestSpecBuilder();
		reqbuilder.setContentType(APP_CONTENT_TYPE);
		RestAssured.requestSpecification = reqbuilder.build();
		
		ResponseSpecBuilder resbuilder = new ResponseSpecBuilder();
		resbuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resbuilder.build();
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

}
