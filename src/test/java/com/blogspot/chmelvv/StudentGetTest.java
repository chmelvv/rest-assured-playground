package com.blogspot.chmelvv;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentGetTest {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
	}

	@Test
	public void getAllStudentInformation(){
		given()
			.when()
			.get("/list")
			.then()
			.statusCode(200);


	}
}
