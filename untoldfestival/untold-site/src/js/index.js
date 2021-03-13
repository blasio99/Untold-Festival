console.clear();

var welcome_text = document.getElementById("welcome");
var user = JSON.parse(localStorage.getItem("user"));
var get_started_button = document.getElementById("done_button");

welcome_text.innerHTML = "Welcome " + user.userName + ".";


function httpGet(theUrl, entries)
{
    var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(JSON.stringify(entries));
	
	return xmlHttp.responseText;
}

function httpPost(theUrl, entries)
{
	var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( 'POST', theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify(entries));
	
    return xmlHttp.responseText;
}

var HttpClient = function() {
	this.get = function(aUrl, aCallback) {
		var anHttpRequest = new XMLHttpRequest();
		anHttpRequest.onreadystatechange = function() { 
			if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
				aCallback(anHttpRequest.responseText);
		}
  
		anHttpRequest.open( "GET", aUrl, true );            
		anHttpRequest.send( null );
	}
	this.post = function(aUrl, aCallback) {
	  var anHttpRequest = new XMLHttpRequest();
	  anHttpRequest.onreadystatechange = function() { 
		  if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
			  aCallback(anHttpRequest.responseText);
	  }
  
	  anHttpRequest.open( "POST", aUrl, true );            
	  anHttpRequest.send( null );
  }
}
  
var client = new HttpClient();
var host = 'http://127.0.0.1:8080/';

const button = document.getElementById('add-button');
const country = document.getElementById('country');
const description = document.getElementById("description");
const searchButton = document.getElementById("searchButton");
const searchedUser = document.getElementById("searchBar");

if(button!=null)
button.addEventListener('click', (e) => {
	var country_var = country.value;
	var description_var = description.value;
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = today.getFullYear();
	today = mm + '/' + dd + '/' + yyyy;
	


	//if(date_var[2]!="/" && date_var[5]!="/" && date_var.length != 10){
		var entries = {country: country_var, description: description_var, date: today};
		let response = httpPost(host + 'api/user/visit/' + user.userName, entries);

		if(response.localeCompare("OK")){
			console.log("ok");
			refreshMap();
		}
		else console.log("bad");
		
	//}
	//document.getElementById('start').value = "";
	//document.getElementById('description').value = "";
});
if(searchButton!=null)
searchButton.addEventListener('click', (e) => {
	var search_username = searchedUser.value;
	document.getElementById('description').value = "--"+search_username;
	if(search_username != null) {
		console.log(search_username);
		let responseSearch = httpGet(host + '/user/name/' + search_username);
		console.log(responseSearch);
			if(response != []) {
				localStorage.setItem("search_user", responseSearch);
				window.location.href = '../html/other_user.html';
		}
	}
	//document.getElementById('login-username').value = "";
});

