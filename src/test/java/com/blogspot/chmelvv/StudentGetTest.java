package com.blogspot.chmelvv;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//import static com.jayway.restassured.RestAssured.*;

public class StudentGetTest {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
	}

	@Test
	public void getAllStudentInformation(){

//		Response response = given()
//				.when()
//				.get("/list");
//
//		System.out.println(response.body().prettyPrint());

		given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);


	}
}
