package com.scc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tuesdayProducer.tuesdayProducer.BookRack;
import com.tuesdayProducer.tuesdayProducer.BooksController;
import com.tuesdayProducer.tuesdayProducer.TuesdayProducerApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TuesdayProducerApplication.class)
public class BooksBase {

  @Autowired
  MockMvc mockMvc;

  private BookRack bookRack = new BookRack();

  @Before
  public void setup() {
    RestAssuredMockMvc.standaloneSetup(new BooksController(bookRack));
  }

  @Test
  public void name() throws Exception {
    mockMvc.perform(post("/pubYear").param("year", "2001")).andExpect(status().isOk());
  }
}
