package com.tuesdayProducer.tuesdayProducer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookTests {

  private BookRack bookRack = new BookRack();

  @Test
  public void shouldReturnBookByAuthor() {
    assertEquals("John Bevere", bookRack.findByAuthor("Bevere").getAuthor());
  }
}
