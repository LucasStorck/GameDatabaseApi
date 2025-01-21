package org.lucas.services;

import org.lucas.entities.Game;
import org.lucas.repositories.GameRepository;

import java.sql.SQLException;
import java.util.List;

public class GameService {

  private final GameRepository repository = new GameRepository();

  public List<Game> getAllGames() throws SQLException {
    return repository.getAllGames();
  }

  public Game getGameById(int id) throws SQLException {
    return repository.getGameById(id);
  }

  public void createGame(Game game) throws SQLException {
    repository.createGame(game);
  }

  public void updateGame(Game game) throws SQLException {
    repository.updateGame(game);
  }

  public void deleteGame(int id) throws SQLException {
    repository.deleteGame(id);
  }
}
