package dao;

import java.sql.*;

public class DBConnect {

  private static Connection dbConnection;

  //метод устанавливает соединение с БД.
  protected static Connection getConnections() throws SQLException {
    System.out.println("Подключаемся к базе данных...");
    return DriverManager.getConnection("jdbc:h2:./src/main/resources/Users");
  }

  //метод отправляет запрос в БД с запрашиваемым именем,
  // при нахождении возвращает строку с найдеными именем и фамилией.
  protected static String findByName(String name) throws SQLException {
    String s;
    try {
      dbConnection = getConnections();
      System.out.println("БД подключена");
      System.out.println("Поиск пользователя...");
      PreparedStatement stmt = dbConnection
          .prepareStatement("SELECT * FROM ACCOUNTS where name = ?");
      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        s = String.format("User{name='%s', SURNAME='%s'}\n", rs.getString("NAME"),
            rs.getString("SURNAME"));
      } else {
        s = "Пользователь не найден";
      }

    } catch (SQLException e) {
      s = e.getMessage();
    }
    dbConnection.close();
    return s;
  }

  //Метод отправляет запрос на изменение фамилии если пользователь был найден.
  protected static String replaceSurname(String name, String newSurname) {
    String s;
    try {
      dbConnection = getConnections();
      System.out.println("БД подключена");
      System.out.println("Поиск пользователя...");
      PreparedStatement stmt = dbConnection
          .prepareStatement("SELECT * FROM ACCOUNTS where name = ?");
      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        stmt = dbConnection.prepareStatement("UPDATE ACCOUNTS SET SURNAME = ? WHERE NAME = ?");
        stmt.setString(1, newSurname);
        stmt.setString(2, name);
        stmt.executeUpdate();
        dbConnection.close();
        s = "Фамилия у пользователя " + name + " обновлена";
      } else {
        s = "Пользователь не найден";
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      s = "Пользователь не найден";
    }
    return s;
  }

  //метод выводит таблицу для просмотра
  protected static void showTable() throws SQLException {
    dbConnection = getConnections();
    System.out.println("БД подключена");
    Statement statement = dbConnection.createStatement();
    ResultSet rs = statement.executeQuery("SELECT * FROM ACCOUNTS order by name");
    System.out.println("Выводим таблицу....");
    System.out.println("----------------ACCOUNTS--------------");

    while (rs.next()) {
      System.out
          .printf("{NAME ='%s', surname='%s'}\n", rs.getString("NAME"), rs.getString("SURNAME"));
    }
    System.out.println("-------------конец таблицы------------");


  }
}
