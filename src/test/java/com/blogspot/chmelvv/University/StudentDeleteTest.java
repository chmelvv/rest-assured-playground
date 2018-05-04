package com.blogspot.chmelvv.University;

import com.blogspot.chmelvv.BaseTest;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends BaseTest {

	@Test
	public void deleteStudent(){
		given()
				.contentType(ContentType.JSON)
				.when()
				.delete("/101")
				.then()
				.statusCode(204);

	}
}
