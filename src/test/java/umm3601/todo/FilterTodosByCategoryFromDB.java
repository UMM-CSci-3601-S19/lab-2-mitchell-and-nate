package umm3601.todo;

import org.junit.Test;
import umm3601.user.Database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategoryFromDB {

  @Test
  public void filterTodosByCategory() throws IOException {
    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    todo[] allTodos = tdb.listTodos(new HashMap<>());

    todo[] catGroceriesTodos = tdb.filterTodosByCategory(allTodos, "groceries");
    assertEquals("Incorrect number of todos with category of groceries", 76, catGroceriesTodos.length);

    todo[] catHomeworkTodos = tdb.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect number of todos with category homework", 79, catHomeworkTodos.length);
  }

  @Test
  public void listTodosWithCategoryFilter() throws IOException {
    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[]{"groceries"});
    todo[] catGroceriesTodos = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of todos of category groceries", 76, catGroceriesTodos.length);

    queryParams.put("category", new String[]{"homework"});
    todo[] catHomeworkTodos = tdb.listTodos(queryParams);
    assertEquals("Incorrect number of users with age 33", 79, catHomeworkTodos.length);
  }
}
