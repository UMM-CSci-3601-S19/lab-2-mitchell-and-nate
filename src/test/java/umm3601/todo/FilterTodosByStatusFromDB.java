package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests the filtering of the list by status function we made
 */
public class FilterTodosByStatusFromDB {

  @Test
  public void listUsersWithStatusFilter() throws IOException {
    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[]{"incomplete"});
    todo[] todosThatAreFalse = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of false todos", 157,todosThatAreFalse.length);

    queryParams.put("status", new String[]{"complete"});
    todo[] todosThatAreTrue = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of true todos", 143, todosThatAreTrue.length);

    queryParams.put("status", new String[]{"thisisastupidstring"});
    todo[] todosThatAreNeither = tdb.listTodos(queryParams);
    assertEquals("The way our program is coded, this should return 300 " +
      "when a non-existant status is entered", 300, todosThatAreNeither.length);

  }
}
