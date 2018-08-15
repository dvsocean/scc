package com.tuesdayConsumer.tuesdayConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BooksController {

  @Bean
  private RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @PostMapping("/bookByAuthor")
  public Books shouldReturnBookByAuthor(){
    HttpEntity<Books> req = new HttpEntity<>(new Books());
    return restTemplate().postForObject("http://localhost:5555/bookByAuthor", req, Books.class);
  }

  @GetMapping("/title/{title}")
  public Books shouldReturnByTitle(@PathVariable("title") String title){
    return restTemplate().getForObject("http://localhost:5555/title/" + title, Books.class);
  }

}
