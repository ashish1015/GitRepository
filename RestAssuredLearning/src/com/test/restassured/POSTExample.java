package com.test.restassured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
public class POSTExample {
	@Test
	public void createPlaceAPI()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().
				queryParam("key", "qaclick123").
				body("{" +
						"\"location\": {" +
						"\"lat\": -33.8669710," +
						"\"lng\": 151.1958750" +
						"}," +
						"\"accuracy\": 50," +
						"\"name\": \"Google Shoes!\"," +
						"\"phone_number\": \"(02) 9374 4000\"," +
						"\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," +
						"\"types\": [\"shoe_store\"]," +
						"\"website\": \"http://www.google.com.au/\"," +
						"\"language\": \"en-AU\"" +
						"}")
				.
				when().
				post("/maps/api/place/add/json").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("status", equalTo("OK"));
		System.out.println("Test Completed");
		// Create a place =response (place id)
		// delete Place = (Request - Place id)
	}
}
