package com.blogspot.chmelvv.University;

import com.blogspot.chmelvv.BaseTest;
import com.blogspot.chmelvv.Student;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends BaseTest {

	@Test
	public void updateStudent(){
		/**
		 *
		 * Minimum put request
		{
		 "firstName": "Chmel",
		 "programme": "Lovely programme",
		 "email": "chmelvv@ukt.net"
		 }
		 */

		Student student = new Student();
		student.setFirstName("Chmel");
		student.setProgramme("Lovely secret progreamme");
		student.setEmail("chmelvv@ukr.net");

		given()
				.contentType(ContentType.JSON)
				.when()
				.body(student)
				.put("/101")
				.then()
				.statusCode(200);

	}
}
