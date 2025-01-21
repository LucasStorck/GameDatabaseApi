package org.lucas.repositories;

import org.lucas.configs.Database;
import org.lucas.entities.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {

  public List<Game> getAllGames() throws SQLException {
    List<Game> gameList = new ArrayList<>();
    String query = "SELECT * FROM games";

    try (Connection connection = Database.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
      while (resultSet.next()) {
        gameList.add(new Game(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("genre"),
                resultSet.getString("publisher"),
                resultSet.getString("developers"),
                resultSet.getString("platforms"),
                resultSet.getString("release")
        ));
      }
    }
    return gameList;
  }

  public Game getGameById(int id) throws SQLException {
    String query = "SELECT * FROM games WHERE id = ?";
    try (Connection connection = Database.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        return new Game(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("genre"),
                resultSet.getString("publisher"),
                resultSet.getString("developers"),
                resultSet.getString("platforms"),
                resultSet.getString("release")
        );
      }
    }
    return null;
  }

  public void createGame(Game game) throws SQLException {
    String query = "INSERT INTO games (title, genre, publisher, developers, platforms, release) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection connection = Database.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, game.getTitle());
      statement.setString(2, game.getGenre());
      statement.setString(3, game.getPublisher());
      statement.setString(4, game.getDevelopers());
      statement.setString(5, game.getPlatforms());
      statement.setString(6, game.getRelease());
      statement.executeUpdate();

    }
  }

  public void updateGame(Game game) throws SQLException {
    String query = "UPDATE games SET title = ?, genre = ?, publisher = ?, developers = ?, platforms = ?, release = ? WHERE id = ?";
    try (Connection connection = Database.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, game.getTitle());
      statement.setString(2, game.getGenre());
      statement.setString(3, game.getPublisher());
      statement.setString(4, game.getDevelopers());
      statement.setString(5, game.getPlatforms());
      statement.setString(6, game.getRelease());
      statement.setInt(7, game.getId());
      statement.executeUpdate();
    }
  }

  public void deleteGame(int id) throws SQLException {
    String query = "DELETE FROM games WHERE id = ?";
    try (Connection connection = Database.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

      statement.setInt(1, id);
      statement.executeUpdate();
    }
  }
}
