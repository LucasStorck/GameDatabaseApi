package org.lucas;

import org.lucas.configs.DatabaseInitializer;
import org.lucas.controllers.GameController;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {

    DatabaseInitializer.initializeDatabase();
    try {
      new GameController().startServer();
      System.out.println("Server Started");
    } catch (IOException exception) {
      System.err.println("Error Starting Server");
    }
  }
}