package com.blogspot.chmelvv.University;

import com.blogspot.chmelvv.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentLoggingTest extends BaseTest {

	@Test
	public void getAllStudentInformation(){

		given()
			.when()
				.log()
				.all()
			.get("/list")
			.then()
				.log()
				.all()
			.statusCode(200);


	}
}
