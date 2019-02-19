package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Tests umm3601.user.Database listUser functionality
 */
public class FullTodoListFromDB {

  @Test
  public void totalUserCount() throws IOException {
    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    todo[] allTodos = tdb.listTodos(new HashMap<>());
    assertEquals("Incorrect total number of todos", 300, allTodos.length);
  }

  @Test
  public void firstTodoInFullList() throws IOException {
    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
    todo[] allTodos = tdb.listTodos(new HashMap<>());
    todo firstTodo = allTodos[0];
    assertEquals("Incorrect owner", "Blanche", firstTodo.owner);
    assertEquals("Incorrect status", false, firstTodo.status);
    assertEquals("Incorrect category", "software design", firstTodo.category);
    assertEquals("Incorrect id", "58895985a22c04e761776d54", firstTodo._id);
  }
}
