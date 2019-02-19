package umm3601.todo;
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
//this file is mostly for testing the number of todos that are displayed

  @Test
  public void testLimitingTodos() throws IOException {

    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("number", new String[]{"10"});
    todo[] listOfTen = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of users displayed, should display 10 but didn't.", 10, listOfTen.length);

    queryParams.put("number", new String[]{"35"});
    todo[] listOfThirtyFive = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of users displayed, should display 35, but didn't.", 35, listOfThirtyFive.length);

    queryParams.put("number", new String[]{"100000"});
    todo[] listOfAll = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of users displayed, should display 300, but didn't.", 300, listOfAll.length);


  }

  }

