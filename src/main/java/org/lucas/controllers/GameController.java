package org.lucas.controllers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import org.lucas.entities.Game;
import org.lucas.services.GameService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class GameController {
  private final GameService gameService = new GameService();

  public void startServer() throws IOException {
    Gson gson = new Gson();
    HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

    httpServer.createContext("/games", exchange -> {
      String method = exchange.getRequestMethod();
      String response = "";

      try {
        if ("GET".equals(method)) {
          String path = exchange.getRequestURI().getPath();
          if (path.contains("/games/")) {
            int id = Integer.parseInt(path.split("/")[2]);
            Game game = gameService.getGameById(id);
            response = gson.toJson(game);
          } else {
            List<Game> gameList = gameService.getAllGames();
            response = gson.toJson(gameList);
          }
        } else if ("POST".equals(method)) {
          InputStreamReader reader = new InputStreamReader(exchange.getRequestBody());
          Game game = gson.fromJson(reader, Game.class);
          game.validateFields();
          gameService.createGame(game);
          response = gson.toJson(game);
        } else if ("PUT".equals(method)) {
          InputStreamReader reader = new InputStreamReader(exchange.getRequestBody());
          Game game = gson.fromJson(reader, Game.class);
          gameService.updateGame(game);
          response = gson.toJson(game);
        } else if ("DELETE".equals(method)) {
          int id = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[2]);
          gameService.deleteGame(id);
          response = "GAME DELETED";
        }
      } catch (Exception exception) {
        response = "ERROR" + exception.getMessage();
      }

      exchange.sendResponseHeaders(200, response.length());
      OutputStream outputStream = exchange.getResponseBody();
      outputStream.write(response.getBytes());
      outputStream.close();
    });
    httpServer.start();
  }
}
