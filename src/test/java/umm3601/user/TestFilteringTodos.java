package umm3601.user;
import umm3601.todo.*;
  import com.google.gson.Gson;
  import org.junit.Test;
  import java.io.FileReader;
  import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
  import static org.junit.Assert.assertTrue;
  import static junit.framework.TestCase.assertEquals;



public class TestFilteringTodos {


  @Test
  public void testthing() throws IOException {

      Database db = new Database("src/main/data/todos.json");
      Map<String, String[]> queryParams = new HashMap<>();

      queryParams.put("number", new String[]{"10"});
      //todo[] listOfTen = db.listTodos(queryParams);
      //assertEquals("Incorrect number of users with age 27", 10, listOfTen.length);

      queryParams.put("age", new String[]{"33"});
      User[] age33Users = db.listUsers(queryParams);
      assertEquals("Incorrect number of users with age 33", 1, age33Users.length);
    }
  }

