package com.tuesdayConsumer.tuesdayConsumer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(ids = "com.tuesdayProducer:tuesdayProducer:+:stubs:5555", stubsMode = StubsMode.LOCAL)
public class ContractTestProducerService {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void shouldVerifyContract() throws Exception {
    mockMvc.perform(post("/bookByAuthor").param("author", "Jakes"))
        .andExpect(status().isOk()).andExpect(jsonPath("author").value("TD Jakes"))
        .andExpect(jsonPath("title").value("Identity"))
        .andExpect(jsonPath("pubYear").value(2017));
  }

  @Test
  public void shouldVerifyByTitle() throws Exception {
    mockMvc.perform(get("/title/Identity")).andExpect(status().isOk())
        .andExpect(jsonPath("author").value("TD Jakes"))
        .andExpect(jsonPath("title").value("Identity"))
        .andExpect(jsonPath("pubYear").value(2017));
  }
}
