package com.blogspot.chmelvv.University;

import com.blogspot.chmelvv.BaseTest;
import com.blogspot.chmelvv.Student;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends BaseTest {

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
				.log() //log request
				.ifValidationFails()
				.contentType(ContentType.JSON)
				.when()
				.body(student)
				.post()
				.then()
				.log() // log response
				.ifValidationFails()
				.statusCode(200);

	}
}
