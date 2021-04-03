console.clear();

var httpRequest;
var host = 'http://localhost:8080/';
var admin = "admin/api/";
var user  = "api/";

const doc0 = document.getElementById("showData").addEventListener('click', makeRequest(host + user + "concert/all"));
//const doc1 = document.getElementById("showDataTicketsSold").addEventListener('click', makeRequest(host + user + "tickets/1"));
//const doc2 = document.getElementById("showDataTickets").addEventListener('click', makeRequest(host + user + "concert/all"));
var colConcert = ["#", "Performer", "Genre", "Title", "Start Time", "End Time", "Max Spectators"];
var colTickets = ["#", "Price", "Number of seats", "Concert ID"];
var colTicketsSold = ["#", "Performer", "Price", "Max Spectators", "Occupied seats"];

function makeRequest(url) {
	httpRequest = new XMLHttpRequest();

	if (!httpRequest) {
	  alert('Giving up :( Cannot create an XMLHTTP instance');
	  return false;
	}
	httpRequest.onreadystatechange = alertContents;
	httpRequest.open('GET', url, true);
	httpRequest.send();
}

function alertContents() {
	if (httpRequest.readyState === XMLHttpRequest.DONE) {
	  if (httpRequest.status === 200) {
		var response = httpRequest.responseText;
		createTable( response, colConcert);
	  } else {
		console.log('There was a problem with the request.');
	  }
	}
}

function createTable(response, colList){

	list = JSON.parse(response);

	var col = [];
	for (var i = 1; i < list.length; i++) {
		for (var key in list[i]) {
			if (col.indexOf(key) === -1) {
				col.push(key);	
			}	
		}
	}
	//console.log(col);

	// CREATE DYNAMIC TABLE.
	var table = document.createElement("table");

	// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

	var tr = table.insertRow(-1);                   // TABLE ROW.

	for (var i = 1; i < colList.length; i++) {
		var th = document.createElement("th");      // TABLE HEADER.
		th.innerHTML = colList[i];
		tr.appendChild(th);
	}

	// ADD JSON DATA TO THE TABLE AS ROWS.
	for (var i = 0; i < list.length; i++) {

		tr = table.insertRow(-1);

		for (var j = 1; j < col.length; j++) {
			var tabCell = tr.insertCell(-1);
			var elem = list[i][col[j]];
			if(j == 4 || j == 5) 
				elem = elem.substring(0,10) + " - " +
					   elem.substring(11, 16);
			
			tabCell.innerHTML = elem;
		}
	}

	// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
	var divContainer = document.getElementById("showData");
	divContainer.innerHTML = "";
	divContainer.appendChild(table);

}