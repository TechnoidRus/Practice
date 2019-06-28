package dao;

import java.sql.SQLException;

public interface Dao {

  void findByName(String name) throws SQLException;

  void showTable() throws SQLException;

  void replaceSurname(String name, String newSurname);

}
