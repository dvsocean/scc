package com.scc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tuesdayProducer.tuesdayProducer.BookRack;
import com.tuesdayProducer.tuesdayProducer.BooksController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

public class BooksBase {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private BooksController booksController;

  @Before
  public void setup() {
    StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(booksController);
    RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
  }

  @Test
  public void shouldReturnBook() throws Exception {
    mockMvc.perform(post("/bookByAuthor").param("author", "Jakes")).andExpect(status().isOk());
  }

//  @Test
//  public void confirmReturnDataFromBookRack() {
//    MockMvcRequestSpecification request = given();
//
//    ResponseOptions response = given().spec(request)
//        .queryParam("author", "Jakes")
//        .post("/bookByAuthor");
//
//    assertThat(response.statusCode()).isEqualTo(200);
//
//  }

}
