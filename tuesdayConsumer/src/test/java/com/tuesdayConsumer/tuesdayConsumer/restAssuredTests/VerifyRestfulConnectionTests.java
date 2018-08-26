package com.tuesdayConsumer.tuesdayConsumer.restAssuredTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import io.restassured.RestAssured;
import org.junit.Test;

public class VerifyRestfulConnectionTests {

  @Test
  public void shouldReturnBooksByAuthor() {
    RestAssured.given().param("author", "TD Jakes").post("http://localhost:5555/bookByAuthor")
        .then().body("title", equalTo("Identity"));
  }

  @Test
  public void shouldReturnByTitle() {
    RestAssured.given().get("http://localhost:5555/title/Relentless").then()
        .statusCode(200)
        .body("author", is("John Bevere"))
        .body("pubYear", is(2017)).log().all();
  }
}
