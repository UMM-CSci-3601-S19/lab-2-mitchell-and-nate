package umm3601.todo;

import com.google.gson.Gson;
import umm3601.user.User;

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

    // Maybe add some filtering later, see the mirrored Database.java class
    if (queryParams.containsKey("number")) {
      int numberShown = Integer.parseInt(queryParams.get("number")[0]);
      //unfinished above line
      filteredTodos= limitTodosShown(filteredTodos, numberShown);
    }


    return filteredTodos;
  }


  public todo[] limitTodosShown(todo[] tempTodos, int numberShown) {
    todo[] limitedTodos;
      limitedTodos= Arrays.stream(tempTodos).limit(numberShown).toArray(todo[]::new);
      return limitedTodos;
    }


}
