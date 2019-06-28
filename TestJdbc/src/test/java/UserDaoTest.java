import dao.DBConnect;
import dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.sql.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDaoTest {


  @Mock
  UserDao us;


  @Test
  public void findByNameTest() throws SQLException {
    String name = "Name";
    String wrong = "bad request";
    us.findByName(name);
    doThrow(new SQLException()).when(us).findByName(wrong);
    verify(us).findByName(name);

  }

  @Test
  public void replaceSurname() {
    String name = "Name";
    String newSurname = "Surname";
    us.replaceSurname(name,newSurname);
    doThrow(new RuntimeException()).when(us).replaceSurname("badName", "badSurname");
    verify(us).replaceSurname(name,newSurname);
  }


  @Test
  public void showTable() throws SQLException {
    us.showTable();
    doThrow(new RuntimeException()).when(us).showTable();
    verify(us).showTable();
  }

}
