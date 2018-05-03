package com.blogspot.chmelvv;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPostTest {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
	}

	@Test
	public void createNewStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");

		Student student = new Student();
		student.setFirstName("Viktor");
		student.setLastName("Chmel");
		student.setEmail("viktor.chmel@gmail.com");
		student.setProgramme("Radiophysics");
		student.setCourses(courses);

		given()
				.contentType(ContentType.JSON)
				.when()
				.body(student)
				.post()
				.then()
				.statusCode(201);

	}
}
