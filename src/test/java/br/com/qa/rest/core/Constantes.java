package br.com.qa.rest.core;

import org.hamcrest.Matcher;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "https://barrigarest.wcaquino.me";
	Integer APP_PORT = 443;
	String APP_BASE_PATH = "";
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	long MAX_TIMEOUT = 5000;

}
