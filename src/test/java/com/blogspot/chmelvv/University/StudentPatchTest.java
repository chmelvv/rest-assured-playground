package com.blogspot.chmelvv.University;

import com.blogspot.chmelvv.BaseTest;
import com.blogspot.chmelvv.Student;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends BaseTest {

	@Test
	public void updateStudent(){

		Student student = new Student();
		student.setEmail("chmelvv@ukr.net");

		given()
				.contentType(ContentType.JSON)
				.when()
				.body(student)
				.patch("/101")
				.then()
				.statusCode(200);

	}
}
