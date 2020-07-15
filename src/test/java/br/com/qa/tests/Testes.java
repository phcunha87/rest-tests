package br.com.qa.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.qa.core.BaseTest;
import br.com.qa.pages.ContaPage;

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
		
		given()
		  .header("Authorization","JWT " +token)
		.body(cp)
		  .when()
		.post("/contas")
		  .then()
		.statusCode(201)
		;
	}
	
	

}
