package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests the filtering of the list by owner function we made
 */
public class FilterTodosByOwnerFromDB {

  @Test
  public void listUsersWithOwnerFilter() throws IOException {
    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[]{"Fry"});
    todo[] todosByFry = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of todos from owner Fry", 61, todosByFry.length);

    queryParams.put("owner", new String[]{"Barry"});
    todo[] todosByBarry = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of todos from owner Barry", 51, todosByBarry.length);

    queryParams.put("owner", new String[]{"Noone"});
    todo[] todosByNoone = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of todos returned from entering a" +
      "non existant owner, should return zero, but didn't", 0, todosByNoone.length);

  }
}
