


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
  var el = document.getElementById("status")
  HttpThingy.get("/api/todo?status=" + el.options[el.selectedIndex].value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}


function filterByBodyContents() {
  console.log("Getting all the todos containing a certain string.");
  var HttpThingy2 = new HttpClient();
  HttpThingy2.get("/api/todo?contains="+ document.getElementById("bodyContains").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterByCategory() {
  console.log("Getting all the todos for a certain category.");
  var HttpThingy2 = new HttpClient();
  HttpThingy2.get("/api/todo?category="+ document.getElementById("category").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterByOwner() {
  console.log("Getting all the todos for a specific owner.");
  var HttpThingy2 = new HttpClient();
  HttpThingy2.get("/api/todo?owner="+ document.getElementById("owner").value, function (returned_json) {
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

function orderByParameter() {
  console.log("OrderBy doesn't do anything beyond this point. Sorry to crush your dreams.");
  var HttpThingy2 = new HttpClient();
  var el = document.getElementById("orderBy");
  HttpThingy2.get("/api/todo?orderBy="+ el.options[el.selectedIndex].value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });

}

function sortByAll() {
  console.log("Sorting by all parameters");
  var HttpThingy2 = new HttpClient();

  // Here's the base request
  var stem = "/api/todo?"
  var el = document.getElementById("status")
  if (el.options[el.selectedIndex].value != "") {
    stem = stem.concat("status=", el.options[el.selectedIndex].value, "&")
  }
  if (document.getElementById("bodyContains").value != "") {
    stem = stem.concat("contains=", document.getElementById("bodyContains").value, "&");
  }
  if (document.getElementById("category").value != "") {
    stem = stem.concat("category=", document.getElementById("category").value, "&");
  }
  if (document.getElementById("owner").value != "") {
    stem = stem.concat("owner=", document.getElementById("owner").value, "&");
  }
  if (document.getElementById("NumberDisplayed").value != "" &&
        document.getElementById("NumberDisplayed").value >= 0) {
    stem = stem.concat("number=", document.getElementById("NumberDisplayed").value, "&");
  }

  el = document.getElementById("orderBy")
  if (el.options[el.selectedIndex].value != "") {
    stem = stem.concat("orderBy=", el.options[el.selectedIndex].value, "&");
    console.log("OrderBy doesn't do anything beyond this point. Sorry to crush your dreams.");
  }

  //Here, we trim the last ampersand off the request
  stem = stem.substr(0, stem.length-1)

    HttpThingy2.get(stem, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;

    // print the request to the browser console, for debugging
    console.log(stem)
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
