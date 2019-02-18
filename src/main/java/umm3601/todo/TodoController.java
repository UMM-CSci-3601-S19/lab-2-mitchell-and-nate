package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.*;

/**
 * Controller that manages requests for info about users.
 */
public class TodoController {

  private final Gson gson;
  private TodoDatabase todoDatabase;

  /**
   * Construct a controller for users.
   * <p>
   * This loads the "database" of user info from a JSON file and
   * stores that internally so that (subsets of) users can be returned
   * in response to requests.
   *
   * @param todoDatabase the database containing user data
   */
  public TodoController(TodoDatabase todoDatabase) {
    gson = new Gson();
    this.todoDatabase = todoDatabase;
  }

  public JsonObject getControllerTodos(Request req, Response res) {
    res.type("application/json");
    todo[] todos = todoDatabase.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }

//  public JsonObject getControllerTodosNumber(Request req, Response res) {
//    res.type("application/json");
//    String id = req.params("number");
//    todo[] tempTodo = TodoDatabase.getTodos();
//    if (tempTodo != null) {
//      return buildSuccessJsonResponse("number", gson.toJsonTree(tempTodo));
//    } else {
//      String message = "User with ID " + id + " wasn't found.";
//      return buildFailJsonResponse("id", message);
//  }
//
}
