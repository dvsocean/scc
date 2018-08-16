package com.scc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TuesdayProducerApplication.class)
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
  public void returnBookByAuthor() throws Exception {
    mockMvc.perform(post("/bookByAuthor").param("author", "TD Jakes"))
        .andExpect(status().isOk()).andExpect(jsonPath("pubYear").value(2017));
  }
}
