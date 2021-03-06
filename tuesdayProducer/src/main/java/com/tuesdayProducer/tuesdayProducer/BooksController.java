package com.tuesdayProducer.tuesdayProducer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
public class BooksController {

  @Autowired
  private BookRack bookRack;

  @PostMapping("/bookByAuthor")
  public Books findByAuthor(@RequestParam("author") String author){
    return bookRack.findByAuthor(author);
  }

  @GetMapping("/title/{title}")
  public Books fetchTitle(@PathVariable("title") String title){
    return bookRack.findByTitle(title);
  }

  @GetMapping("/all")
  public List<Books> returnAllBooks(){
    return bookRack.showList();
  }

  @PostMapping("/pubYear")
  public Books findByYear(@RequestParam("year") int year){
    return bookRack.findByPubYear(year);
  }

  @PostMapping("/create")
  public Books addBook(@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("pubYear") int pubYear){
    return bookRack.addBook(title, author, pubYear);
  }

  @PutMapping("/update")
  public Books updateResource(@RequestParam("title") String title, @RequestParam("editor") String editor, @RequestParam("isReleased") boolean isReleased, @RequestParam("movie") String movie){
    return bookRack.updateResource(title, editor, isReleased, movie);
  }

  @DeleteMapping("/delete/{title}")
  public String deleteResource(@PathVariable("title") String title){
    bookRack.addBook(title, "Jason Statham", 1998);
    bookRack.addBook("Wrecked", "Jack Sparrow", 1566);
    return bookRack.deleteResource(title);
  }


}//End of class
