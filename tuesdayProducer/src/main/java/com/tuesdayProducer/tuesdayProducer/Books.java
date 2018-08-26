package com.tuesdayProducer.tuesdayProducer;

public class Books {

  private String author;
  private String title;
  private int pubYear;
  private String editor;
  private boolean isReleased;
  private String movie;

  public Books(String title, String author, int pubYear) {
    this.author = author;
    this.title = title;
    this.pubYear = pubYear;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPubYear() {
    return pubYear;
  }

  public void setPubYear(int pubYear) {
    this.pubYear = pubYear;
  }

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public boolean isReleased() {
    return isReleased;
  }

  public void setReleased(boolean released) {
    isReleased = released;
  }

  public String getMovie() {
    return movie;
  }

  public void setMovie(String movie) {
    this.movie = movie;
  }
}
