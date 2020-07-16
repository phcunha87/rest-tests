package br.com.rest.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.rest.core.BaseTest;
import br.com.rest.pages.ContaPage;

public class Testes extends BaseTest{
	
	
	@Test
	public void naoDeveAcessarAPIsemToken() {
		given()
		.when()
		.get("/contas")
		.then()
		.log().all()
		.statusCode(401)
		;
	}
	
	@Test
	public void deveIncluirContaComSucesso() {
		String CONTA_NAME = "conta " + System.nanoTime();  
		Map<String,String> login = new HashMap<String, String>();
		login.put("email", "wagner@aquino");
		login.put("senha", "123456");
		
		String token = given()
		.body(login)
		   .when()
		.post("signin")
		   .then()
		.statusCode(200)
		   .extract().path("token")
		;
		
		
		ContaPage cp = new ContaPage();
		cp.setNome(CONTA_NAME);
		
		Integer id = given()
		  .header("Authorization","JWT " +token)
		.body(cp)
		  .when()
		.post("/contas")
		  .then()
		.statusCode(201)
		.extract().path("id")
		;
	}
	
	
	
	

}
