package com.tuesdayProducer.tuesdayProducer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookTDDFirstApplicationTests {

  private BookRack bookRack = new BookRack();

  @Test
  public void shouldReturnBookByAuthor() {
    assertEquals("John Bevere", bookRack.findByAuthor("Bevere").getAuthor());
  }

  @Test
  public void shouldReturnBookByTitle() {
    assertEquals("Identity", bookRack.findByTitle("identity").getTitle());
  }

  @Test
  public void shouldReturnBookByPublishingYear() {
    assertEquals(2017, bookRack.findByPubYear(2017).getPubYear());
  }
}
