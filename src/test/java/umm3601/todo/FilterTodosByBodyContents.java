package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByBodyContents {

    @Test
    public void filterTodosByBodyContents() throws IOException {
      TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
      todo[] allTodos = tdb.listTodos(new HashMap<>());

      todo[] bodyContainsNon = tdb.filterTodosByBodyContents(allTodos, "non tempor");
      assertEquals("Incorrect number of todos with bodies containing non tempor", 4, bodyContainsNon.length);

      todo[] bodyContainsEsse = tdb.filterTodosByBodyContents(allTodos, "esse");
      assertEquals("Incorrect number of todos with category homework", 70, bodyContainsEsse.length);
    }

    @Test
    public void listTodosWithBodyContentsFilter() throws IOException {
      TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
      Map<String, String[]> queryParams = new HashMap<>();

      queryParams.put("contains", new String[]{"bandit"});
      todo[] bodyContainsBlah = tdb.listTodos(queryParams);
      assertEquals("Incorrect number of todos with body containing bandit", 0, bodyContainsBlah.length);

      queryParams.put("contains", new String[]{"commodo amet incididunt anim"});
      todo[] bodyContainsSnippet = tdb.listTodos(queryParams);
      assertEquals("Incorrect number of users with age 33", 1, bodyContainsSnippet.length);
    }
  }


