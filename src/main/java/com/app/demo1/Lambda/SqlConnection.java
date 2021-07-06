package com.app.demo1.Lambda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {


      public Connection sqlConnect() {
          String host = System.getenv("dbHost");
          String port = System.getenv("dbPort");
          String dbName = System.getenv("dbName");
          String username = System.getenv("dbUsername");
          String password = System.getenv("dbPassword");

          Connection connection = null;
          try {
              Class.forName(":: host ::" + host + ":: port ::" + port + ":: dbName ::" + dbName + ":: username ::"
                      + username + ":: password ::" + password);
              String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
              connection = DriverManager.getConnection(url, username, password);
              String sqlQuerry = " sql querry";
              Statement stmt = connection.createStatement();
              stmt.executeUpdate(sqlQuerry);
              System.out.println(":: database connection created ::");
              return connection;
          } catch (ClassNotFoundException | SQLException e) {
              e.printStackTrace();
          }
          return connection;
      }
      }

