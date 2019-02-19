package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.*;

public class TodoController {

  private final Gson gson;
  private TodoDatabase todoDatabase;


  public TodoController(TodoDatabase todoDatabase) {
    gson = new Gson();
    this.todoDatabase = todoDatabase;
  }

  public JsonObject getControllerTodos(Request req, Response res) {
    res.type("application/json");
    todo[] todos = todoDatabase.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }

}
