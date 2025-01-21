package org.lucas.configs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

  private static final String SCHEMA = "src/main/resources/db/schema.sql";

  public static void initializeDatabase() {
    try (Connection conn = Database.getConnection();
         Statement stmt = conn.createStatement()) {

      String sql = Files.readString(Paths.get(SCHEMA));

      String[] commands = sql.split(";");

      for (String command : commands) {
        if (!command.trim().isEmpty()) {
          stmt.execute(command);
        }
      }

      System.out.println("Database Initialized Successfully");

    } catch (IOException e) {
      System.err.println("Error Reading schema.sql File: " + e.getMessage());
    } catch (SQLException e) {
      System.err.println("Error Executing SQL Script: " + e.getMessage());
    }
  }
}
