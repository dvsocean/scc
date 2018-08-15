package com.tuesdayProducer.tuesdayProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

  @Autowired
  private BookRack bookRack;

  @Autowired
  public BooksController(BookRack bookRack) {
    this.bookRack = bookRack;
  }

  @PostMapping("/bookByAuthor")
  public Books findByAuthor(@RequestParam("author") String author){
    return bookRack.findByAuthor(author);
  }
}
