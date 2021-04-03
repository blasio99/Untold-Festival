console.clear();

var httpRequest;

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
		//createTable( response);
	  } else {
		console.log('There was a problem with the request.');
	  }
	}
}
function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(null);
	
	return xmlHttp.responseText;
}

function httpPost(theUrl, user)
{
	var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( 'POST', theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify(user));
	
    //xmlHttp.send( [] );
    return xmlHttp.responseText;
}

function httpDelete(theUrl)
{
	var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( 'DELETE', theUrl, false ); // false for synchronous request
	
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	
	xmlHttp.send(null);
	
    //xmlHttp.send( [] );
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
	/*this.delete = function(aUrl, aCallback) {
		var anHttpRequest = new XMLHttpRequest();
		anHttpRequest.onreadystatechange = function() { 
			if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
				aCallback(anHttpRequest.responseText);
		}
  
		anHttpRequest.open( "DELETE", aUrl, true );            
		anHttpRequest.send( null );
	}*/
}

var host = 'http://localhost:8080/';
var admin = "admin/api/";
var user  = "api/";

const create = document.getElementById('create-button');
const nameCreate = document.getElementById('nameCreate');
const passCreate = document.getElementById('passCreate');

create.addEventListener('click', (e) => {
	var name = nameCreate.value;
	var pass = passCreate.value;
	
	if(name != null && pass != null) {
		
		var user = {username: name, password: pass, role: "CASHIER"};
		
		let response = httpPost(host + admin + 'register/cashier', user);
		//alert(response);
		if(response != []) {
			localStorage.setItem("user", response);
			alert(name +" is a new CASHIER");
			window.location.href = 'crud_cashiers.html';
		}
	}
	//document.getElementById('login-username').value = "";
});

const concert = document.getElementById('concert-button');
const performer = document.getElementById('performer');
const genre = document.getElementById('genre');
const title = document.getElementById('title');
const maxNrOfTickets = document.getElementById('maxnr');
const startDate = document.getElementById('startdate');
const endDate = document.getElementById('enddate');

concert.addEventListener('click', (e) => {
	var per = performer.value;
	var gen = genre.value;
	var tit = title.value;
	var max = maxNrOfTickets.value;
	var sta = startDate.value;
	var end = endDate.value;
	
	if(per != null && pass != null && tit != null && max != null && sta != null && end != null) {
		
		var con = {performer : per, genre : gen, title : tit,
			 max_nr_of_tickets : max, start_time : sta, end_time : end};
		
		let response = httpPost(host + user + 'concert/add', con);
		//alert(response);
		if(response != []) {
			alert(per +" at Untold Festival 2021");
			window.location.href = 'crud_performances.html';
		}
	}
	else alert("Incorrect fill in...");
});

const ban = document.getElementById('delete-button');
const nameDelete = document.getElementById('nameDelete');

ban.addEventListener('click', (e) => {
	var name = nameDelete.value;
	
	if(name != null) {

		httpDelete(host + admin + 'delete/user/' + name);
		alert(name +" is DELETED from the system.");
		window.location.href = 'crud_cashiers.html';
	}
	//document.getElementById('login-username').value = "";
});
