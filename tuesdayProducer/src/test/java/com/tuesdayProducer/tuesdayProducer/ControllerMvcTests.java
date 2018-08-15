package com.tuesdayProducer.tuesdayProducer;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControllerMvcTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnBookByAuthor() throws Exception {
    mockMvc.perform(post("/bookByAuthor").param("author", "Jakes"))
        .andExpect(status().isOk()).andExpect(jsonPath("title").value("Identity"));
  }

  @Test
  public void shouldReturnBookByTitle() throws Exception {
    mockMvc.perform(get("/title/Identity")).andExpect(status().isOk())
        .andExpect(jsonPath("title").value("Identity"));
  }

  @Test
  public void returnBookByPubYear() throws Exception {
    mockMvc.perform(post("/pubYear").param("year", "2001"))
        .andExpect(status().isOk()).andExpect(jsonPath("author").value("Chester Benningington"));
  }

  @Test
  public void returnAllBooks() throws Exception {
    mockMvc.perform(get("/all")).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(12)));
  }
}
