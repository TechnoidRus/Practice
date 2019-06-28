import dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.sql.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDaoTest {


  @Mock
  UserDao us;


  @Test
  public void findByNameTest() throws SQLException {
    doThrow(new RuntimeException()).when(us).findByName("a");
  }

  @Test
  public void replaceSurname() {
    doThrow(new RuntimeException()).when(us).replaceSurname("", "");
  }


  @Test
  public void showTable() throws SQLException {
    doThrow(new RuntimeException()).when(us).showTable();
  }


}
