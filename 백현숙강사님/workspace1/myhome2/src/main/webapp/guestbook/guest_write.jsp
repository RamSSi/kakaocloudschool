<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rapa.control.guestbook.*"  %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
	
	<form name="form">
		<input type="hidden" name="cmd" id="cmd" value="save"/>	
		제목 : <input type="text" name="title" id="title"><br />
		작성자 : <input type="text" name="writer" id="writer"><br />
		내용 : <textarea name="contents" id="contents" rows="5" cols="80"></textarea>
	
		<button type="button" id="btnSend">등록</button>
	</form>
</body>
</html>
<script>
	window.onload = function() {
		document.getElementById("btnSend").addEventListener("click", function () {
			let frm = document.form;
			frm.cmd.values="write";
			frm.action="/myhome2/guest.do";
			frm.method="post";
			frm.submit();
		});
	}
</script>