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

  public todo[] allTodos;

  public TodoDatabase(String userDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(userDataFile);
    allTodos = gson.fromJson(reader, todo[].class);
  }


//  public todo[] getTodos() {
//    return allTodos;
//  }






  //this is from epic #1, list all the todos
  public todo[] listTodos(Map<String, String[]> queryParams) {
    todo[] filteredTodos = allTodos;

    // Filter age if defined
    if (queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status")[0];
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    // Maybe add some filtering later, see the mirrored Database.java class
    if (queryParams.containsKey("number")) {
      int numberShown = Integer.parseInt(queryParams.get("number")[0]);
      //unfinished above line
      filteredTodos= limitTodosShown(filteredTodos, numberShown);
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


  public todo[] limitTodosShown(todo[] tempTodos, int numberShown) {
    todo[] limitedTodos;
      limitedTodos= Arrays.stream(tempTodos).limit(numberShown).toArray(todo[]::new);
      return limitedTodos;
    }


}
