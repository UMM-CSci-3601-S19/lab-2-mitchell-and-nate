


function getAllTodosJS() {
  console.log("Getting all the todos.");

  var HttpThingy2 = new HttpClient();
  HttpThingy2.get("/api/todo", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}


/*
Epic 3: This function is for filtering todos by Status
 */
function getAllTodosByStatus() {
  console.log("Getting all todos by status.");
  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todo?status=" + document.getElementById("status").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterByNumberJS() {
  console.log("Getting all the todos containing a certain string.");
  var HttpThingy2 = new HttpClient();
  HttpThingy2.get("/api/todo?contains="+ document.getElementById("bodyContains").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });

}


function filterByNumberJS() {
  console.log("Getting all the todos. Maybe.");
  var HttpThingy2 = new HttpClient();
  HttpThingy2.get("/api/todo?number="+ document.getElementById("NumberDisplayed").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });

}


function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function (aUrl, aCallback) {
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function () {

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
