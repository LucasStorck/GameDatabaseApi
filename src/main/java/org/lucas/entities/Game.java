package org.lucas.entities;

public class Game {

  private int id;
  private String title;
  private String genre;
  private String publisher;
  private String developers;
  private String platforms;
  private String release;

  public Game(int id, String title, String genre, String publisher, String developers, String platforms, String release) {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.publisher = publisher;
    this.developers = developers;
    this.platforms = platforms;
    this.release = release;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getDevelopers() {
    return developers;
  }

  public void setDevelopers(String developers) {
    this.developers = developers;
  }

  public String getPlatforms() {
    return platforms;
  }

  public void setPlatforms(String platforms) {
    this.platforms = platforms;
  }

  public String getRelease() {
    return release;
  }

  public void setRelease(String release) {
    this.release = release;
  }

  public void validateFields() throws IllegalArgumentException {
    if (title == null || title.trim().isEmpty()) {
      throw new IllegalArgumentException("The 'Title' Field Cannot be Empty");
    }
    if (genre == null || genre.trim().isEmpty()) {
      throw new IllegalArgumentException("The 'Genre' Field Cannot be Empty");
    }
    if (publisher == null || publisher.trim().isEmpty()) {
      throw new IllegalArgumentException("The 'Publisher' Field Cannot be Empty");
    }
    if (developers == null || developers.trim().isEmpty()) {
      throw new IllegalArgumentException("The 'Developers' Field Cannot be Empty");
    }
    if (platforms == null || platforms.trim().isEmpty()) {
      throw new IllegalArgumentException("The 'Platforms' Field Cannot be Empty");
    }
    if (release == null || release.trim().isEmpty()) {
      throw new IllegalArgumentException("The 'Release' Field Cannot be Empty");
    }
  }
}
