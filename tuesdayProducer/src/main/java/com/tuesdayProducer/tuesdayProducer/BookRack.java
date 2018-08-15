package com.tuesdayProducer.tuesdayProducer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BookRack {

  List<Books> list = new ArrayList<>();

  public BookRack() {
    this.list.add(new Books("Relentless", "John Bevere", 2017));
    this.list.add(new Books("Identity", "TD Jakes", 2017));
  }

  public Books findByAuthor(String author) {
      for(Books book: list) {
        if(book.getAuthor().toLowerCase().contains(author.toLowerCase())){
          return book;
        }
      }
    return null;
  }
}
