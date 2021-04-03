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
		exportToCsvFile( JSON.parse(response));
	  } else {
		console.log('There was a problem with the request.');
	  }
	}
}

var host = 'http://localhost:8080/';
var admin = "admin/api/";
var user  = "api/";

function toClick(){
	const doc = document.getElementById("export-button").addEventListener('click', makeRequest(host + user + "concert/all"));
}

function parseJSONToCSVStr(jsonData) {
    if(jsonData.length == 0) {
        return '';
    }

    let keys = Object.keys(jsonData[0]);

    let columnDelimiter = ',';
    let lineDelimiter = '\n';

    let csvColumnHeader = keys.join(columnDelimiter);
    let csvStr = csvColumnHeader + lineDelimiter;

    jsonData.forEach(item => {
        keys.forEach((key, index) => {
            if( (index > 0) && (index < keys.length) ) {
                csvStr += columnDelimiter;
            }
            csvStr += item[key];
        });
        csvStr += lineDelimiter;
    });

    return encodeURIComponent(csvStr);;
}

function exportToCsvFile(jsonData) {
    let csvStr = parseJSONToCSVStr(jsonData);
    let dataUri = 'data:text/csv;charset=utf-8,'+ csvStr;

    let exportFileDefaultName = 'data.csv';

    let linkElement = document.createElement('a');
    linkElement.setAttribute('href', dataUri);
    linkElement.setAttribute('download', exportFileDefaultName);
    linkElement.click();
}