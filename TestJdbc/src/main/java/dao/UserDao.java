package dao;


import java.sql.SQLException;

public class UserDao implements Dao {


  public UserDao() throws SQLException {
    //Загружаем драйвер доя работы с базой данных, БД используется H2.
    try {
      System.out.println("Загружаем драйвер");
      Class.forName("org.h2.Driver");
      System.out.println("Загрузка драйвера успешна");
    } catch (ClassNotFoundException e) {
      System.out.println("Драйвер не найден");
    }

  }

  @Override
  public void findByName(String name) throws SQLException {
    System.out.println(DBConnect.findByName(name));

  }

  @Override
  public void showTable() throws SQLException {
    DBConnect.showTable();
  }

  @Override
  public void replaceSurname(String name, String newSurname) {
    System.out.println(DBConnect.replaceSurname(name, newSurname));
  }


}
