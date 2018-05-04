package com.blogspot.chmelvv.WallMart;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SearchAPITest {
	/**
	 * https://developer.walmartlabs.com
	 * Application: rest-assured-playground
	 * Key: u4e6667xpg9wknqke93u3na6
	 */

	static final String APIKEY = "u4e6667xpg9wknqke93u3na6";

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}

	@Test
	public void usingJSONPathExmaple(){

		int numItems = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("numItems");
		System.out.println("numItems = " + numItems);

		String query = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("query");
		System.out.println("query = " + query);

		String firstFoundItemName = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("items[0].name");
		System.out.println("firstFoundItemName = " + firstFoundItemName);

		HashMap<String, String> giftOptions = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("items[0].giftOptions");
		System.out.println("giftOptions = " + giftOptions);

		int itemsSize = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("items.size()");
		System.out.println("itemsSize = " + itemsSize);

		ArrayList<String> productNames = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract().path("items.name");
		System.out.println("productNames = " + String.join("\n\t", productNames));

		ArrayList<HashMap<String, Object>> specificProductName = given()
				.queryParam("query", "iphone")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then().extract()
				.path("items.findAll{it.name=='IPHONE 6 16GB Gold Unlocked Refurbished'}");

		System.out.println("specificProductName = " + specificProductName);
	}

}
