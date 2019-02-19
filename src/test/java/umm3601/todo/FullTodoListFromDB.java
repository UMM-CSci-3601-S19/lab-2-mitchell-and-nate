//package umm3601.todo;
//
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Tests umm3601.user.Database listUser functionality
// */
//public class FullUserListFromDB {
//
//  @Test
//  public void totalUserCount() throws IOException {
//    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
//    todo[] allTodos = tdb.listTodos(new HashMap<>());
//    assertEquals("Incorrect total number of todos", 300, allTodos.length);
//  }
//
//  @Test
//  public void firstTodoInFullList() throws IOException {
//    TodoDatabase tdb = new TodoDatabase("src/main/data/todos.json");
//    todo[] allUsers = tdb.listTodos(new HashMap<>());
//    todo firstTodo = allUsers[0];
//    assertEquals("Incorrect name", "Connie Stewart", firstUser.name);
//    assertEquals("Incorrect age", 25, firstUser.age);
//    assertEquals("Incorrect company", "OHMNET", firstUser.company);
//    assertEquals("Incorrect e-mail", "conniestewart@ohmnet.com", firstUser.email);
//  }
//}
