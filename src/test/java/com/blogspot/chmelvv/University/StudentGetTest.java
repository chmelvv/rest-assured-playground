package com.blogspot.chmelvv.University;

import com.blogspot.chmelvv.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends BaseTest {

	@Test
	public void getAllStudentInformation(){
		given()
			.when()
			.get("/list")
			.then()
			.statusCode(200);


	}
}
