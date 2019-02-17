package umm3601.todo;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


/**
 * This is a mirror of the provided Database.java object.
 *
 */

public class TodoDatabase {

  private todo[] allTodos;

  public TodoDatabase(String userDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(userDataFile);
    allTodos = gson.fromJson(reader, todo[].class);
  }




  //this is from epic #1, list all the todos
  public todo[] listTodos(Map<String, String[]> queryParams) {
    todo[] filteredTodos = allTodos;

    // Filter age if defined
    if (queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status")[0];
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    return filteredTodos;
  }

  /* Gets an array of todos filtered by their status
   *
   * @param todos an array of all the todos
   * @param targetStatus String that is either 'complete' or 'incomplete' and triggers a conditional
   *                     that checks a todo's status for true or false.
   * @return An array of todos that have been filtered
   */
  public todo[] filterTodosByStatus (todo[] todos, String targetStatus) {
    Boolean boolStatus;
    if (targetStatus.equals("complete")) {
      return Arrays.stream(todos).filter(x -> x.status == true).toArray(todo[]::new);
    }
    else {
      return Arrays.stream(todos).filter(x -> x.status == false).toArray(todo[]::new);
    }

  }


}
