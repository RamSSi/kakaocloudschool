<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous">
</script>
</head>
<body>
	<input type="text" name="number" value="1"><br />
	<input type="text" name="number" value="3"><br />
	<input type="text" name="number" value="11"><br />
	<input type="text" name="number" value="21"><br />
	<input type="text" name="number" value="14"><br />
	<input type="text" name="number" value="11"><br />
	<input type="text" name="number" value="12"><br />
	<input type="text" name="number" value="10"><br />
	<input type="text" name="number" value="19"><br />
	<input type="text" name="number" value="17"><br />
	--------------------------------------------<br>
	<div id="result"></div>
	<button id="btnAdd" type="button">합산하기</button>
</body>
</html>

<script>
	document.getElementById("btnAdd").addEventListener("click", function() {
		let sum = 0;
		document.querySelectorAll("input[type=text][name=number]").forEach((item) => {
			sum += parseInt(item.value);
		});
		document.getElementById("result").innerHTML = sum;
	});
</script>