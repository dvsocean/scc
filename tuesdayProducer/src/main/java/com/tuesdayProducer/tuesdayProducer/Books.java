package com.tuesdayProducer.tuesdayProducer;

public class Books {

  private String author;
  private String title;
  private int pubYear;

  public Books(String title, String author, int pubYear) {
    this.author = author;
    this.title = title;
    this.pubYear = pubYear;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public int getPubYear() {
    return pubYear;
  }
}
