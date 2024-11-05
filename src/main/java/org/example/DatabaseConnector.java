package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/deineDatenbank";
    String user = "deinBenutzer";
    String password = "deinPasswort";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("Verbindung zur Datenbank erfolgreich!");
    } catch (SQLException e) {
      System.out.println("Verbindung fehlgeschlagen.");
      e.printStackTrace();
    }
  }
}
