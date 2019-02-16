package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
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

    // Maybe add some filtering later, see the mirrored Database.java class

    return filteredTodos;
  }


}
