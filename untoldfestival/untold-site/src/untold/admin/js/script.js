console.clear();

const loginBtn = document.getElementById('login-button');


loginBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode.parentNode;
	//console.log("wtf login\n");
	Array.from(e.target.parentNode.parentNode.classList).find((element) => {
		if(element !== "slide-up") {
			parent.classList.add('slide-up')
		}else{
			signupBtn.parentNode.classList.add('slide-up')
			parent.classList.remove('slide-up')
		}
	});
});


function httpGet(theUrl, user)
{
    var xmlHttp = new XMLHttpRequest();
	//var headers = {Authorization : 'Basic $2a$10$emzGRajpkxZ9nr7G8Vnn0ul.0/I3oskXYk8.iwt7P5JJnP67rFBYG'};
	xmlHttp.open("GET", theUrl, false);//, "blasio99", "Ymxhc2lvOTk6YXNk");
	//xmlHttp.withCredentials = true;
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	//xmlHttp.setRequestHeader( 'Accept', 'application/json' );
	//xmlHttp.setRequestHeader("Authorization", "Basic Ymxhc2lvOTk6YXNk");
	
	
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
  var host = 'localhost:8080';


const login = document.getElementById('login-button');

login.addEventListener('click', (e) => {
	

	console.log(httpGet("localhost:8080/api/concert/genre/POP"));

	/*var login_username = "POP";

	if(login_username != null) {
		//var user = {email: login_username, userName: login_username, passWord: login_password};
		//httpProbe();

		console.log(login_username);
		let response = httpGet(host + '/api/concert/genre/' + login_username);
		console.log(response);
		
		var object = JSON.parse(response);
		console.log(object.visits);
			if(response != []) {
				localStorage.setItem("user", response);
				window.location.href = 'tickets.html';
		}
	}
	//document.getElementById('login-username').value = "";*/
});