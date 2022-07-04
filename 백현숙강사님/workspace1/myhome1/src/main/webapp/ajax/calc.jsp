<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	x : <input type="text" name="xvalue" id="xvalue" /><br/>
	y : <input type="text" name="yvalue" id="yvalue" /><br/>
	<button type="button" name="op" id="Add" value="1" onclick="loadData(1)">Add</button>
	<button type="button" name="op" id="Sub" value="2" onclick="loadData(2)">Sub</button>
	<button type="button" name="op" id="Mul" value="3" onclick="loadData(3)">Mul</button>
	<button type="button" name="op" id="Div" value="4" onclick="loadData(4)">Div</button>
	
	<div id="result"></div>
</body>
</html>

<script>
	function loadData(op) {
		let url = "calcData.jsp?xvalue=" + document.getElementById("xvalue").value + "&yvalue=" + document.getElementById("yvalue").value + "&op=" + op;
		console.log(url);
		
		let xhttp = new XMLHttpRequest();	// 비동기 통신 담당 객체
		
		// 통신 중간에 이 필드에 전달된 함수를 호출
		xhttp.onload = function () {
			/* document.getElementById("result").innerHTML = this.responseText;	 */
			console.log( this.responseText);
			let data = JSON.parse(this.responseText);
			if (data.result == "success")
				document.getElementById("result").innerHTML = "값은 " + data.value + " 입니다.";
			else
				document.getElementById("result").innerHTML = "에러 발생";
		}	
		xhttp.open("GET", url, true);
		xhttp.send(); 
	}
</script>