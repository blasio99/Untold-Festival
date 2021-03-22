console.clear();

const loginBtn = document.getElementById('login');


loginBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode.parentNode;
	console.log("wtf login\n");
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
const loginUsername = document.getElementById('login-username');
const loginPassword = document.getElementById('login-pass');

login.addEventListener('click', (e) => {
	var login_username = loginUsername.value;
	var login_password = loginPassword.value;
	
	if(login_username != null) {
		//var user = {email: login_username, userName: login_username, passWord: login_password};
		console.log(login_username + " - " + login_password);
		let response = httpGet('http://127.0.0.1:8080/login/' + login_username + '/' + login_password);
		console.log(response);
		var object = JSON.parse(response);
		console.log(object.visits);
			if(response != []) {
				localStorage.setItem("user", response);
				window.location.href = './admin/index.html';
		}
	}
	//document.getElementById('login-username').value = "";
});