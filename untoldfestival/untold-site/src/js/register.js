console.clear();

const signupBtn = document.getElementById('signup');

signupBtn.addEventListener('click', (e) => {
	let parent = e.target.parentNode;
	Array.from(e.target.parentNode.classList).find((element) => {
		if(element !== "slide-up") {
			parent.classList.add('slide-up')
		}else{
			loginBtn.parentNode.parentNode.classList.add('slide-up')
			parent.classList.remove('slide-up')
		}
	});
});

function httpGet(theUrl, user)
{
    var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(JSON.stringify(user));
	
	return xmlHttp.responseText;
}

function httpPost(theUrl, user)
{
	var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( 'POST', theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify(user));
	
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



const signup = document.getElementById('signup-button');
const signupUsername = document.getElementById("signup-username");

signup.addEventListener('click', (e) => {
	var signup_username = signupUsername.value;
	var signup_password = document.getElementById("signup-pass").value;
	console.log(signup_username+'------\n');
	if(signup_username != null) {
		var user = {username: signup_username, password: signup_password, role: "CASHIER"};
		console.log(JSON.stringify(user));
		let response = httpPost(host + 'admin/api/user/register', user);
		
		if(response.localeCompare("OK")){
			console.log("ok");
		}
		else console.log("bad");
		/*let response = httpGet(host + '/user/' + signup_username);
		console.log(response);
		if(response == []) {
			httpPost(host + '/user/register/' + signup_username);
		}*/
	}
	document.getElementById('signup-username').value = "";
	document.getElementById('signup-pass').value = "";
});