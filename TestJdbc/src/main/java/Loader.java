import dao.UserDao;

import java.sql.SQLException;

public class Loader {

  /**
   * Класс UserDao содержит три метода:
   * showTable() добавил для удобства, что бы было видно изменения.
   * findByName() поиск по имени, если находит то печатает в консоль имя и фамилию.
   * replaceSurname() у юзера с выбранным именем меняет фамилию, если он присутствует в базе.
   * Таблица частично заполнена.
   *  */

  public static void main(String[] args) throws SQLException {

    UserDao ud = new UserDao();
    ud.showTable();
    ud.findByName("Dmitry");
    ud.replaceSurname("Ivan", "Petrov");

  }
}
