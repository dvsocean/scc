package com.tuesdayProducer.tuesdayProducer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BookRack {

  private List<Books> list = new ArrayList<>();

  public BookRack() {
    this.list.add(new Books("Relentless", "John Bevere", 2017));
    this.list.add(new Books("Identity", "TD Jakes", 2017));
    this.list.add(new Books("Stanley Ipcus", "John McDonald", 2009));
    this.list.add(new Books("Moby Dick", "Some guy", 1887));
    this.list.add(new Books("Da vinci code", "Leonardo Da Vinci", 1994));
    this.list.add(new Books("Casino", "Robert De Niro", 1991));
    this.list.add(new Books("Fairgrounds", "Vanessa Blaine Collins", 1985));
    this.list.add(new Books("Jasper Creek", "Rowland Towers", 2017));
    this.list.add(new Books("Runaway", "Chester Benningington", 2001));
    this.list.add(new Books("Schitts Creek", "Rowland Schitts", 2018));
    this.list.add(new Books("Orange is the new Black", "Piper Chapman", 2016));
    this.list.add(new Books("Shawshank Redemption", "Andy Dufrain", 1998));
  }

  public List<Books> showList(){
    return this.list;
  }

  public Books findByAuthor(String author) {
      for(Books book: list) {
        if(book.getAuthor().toLowerCase().contains(author.toLowerCase())){
          return book;
        }
      }
    return null;
  }

  public Books findByTitle(String title) {
    for(Books book: list) {
      if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
        return book;
      }
    }
    return null;
  }

  public Books findByPubYear(int pubYear) {
    for(Books book: list) {
      if(book.getPubYear() == pubYear){
        return book;
      }
    }
    return null;
  }
}
