console.clear();

function httpGet(theUrl, user)
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
  var countrySize = 190;
  var client = new HttpClient();
  var host = 'http://127.0.0.1:8080/api';


const login = document.getElementById('login-button');
const loginUsername = document.getElementById('nameLogin');
const loginPassword = document.getElementById('passLogin');
const roleAdmin = "ADMIN";
const roleCashier = "CASHIER";

login.addEventListener('click', (e) => {
	var login_username = loginUsername.value;
	var login_password = loginPassword.value;

	//alert(login_username + " - " + login_password);
	
	if(login_username != null && login_password != null) {
		var user = {username: login_username, password: login_password};
		let response = httpPost('http://127.0.0.1:8080/login', user);
		//alert(response.status);
		
		var object = JSON.parse(response);


		if(response != []) 
			if(object["role"] == roleAdmin){
				alert("Welcome back Admin " + object["username"] + "!");
				window.location.href = './admin/index.html';
			}
			else if(object["role"] == roleCashier){
				alert("Let's sell some tickets, " + object["username"] + "!");
				window.location.href = './cashier/index.html';
			}
		
	}
});