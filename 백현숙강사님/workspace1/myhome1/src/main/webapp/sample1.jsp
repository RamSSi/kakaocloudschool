<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/jquery/jquery-3.6.0.min.js"></script>

</head>
<body>
	<%=request.getContextPath()%> // 상대주소, 절대주소 없이 파일이 어디있든 Context(경로)를 자동으로 인식해 찾아줌
	url: http://127.0.0.1:8080/myhome1/jquery/sample1.jsp
</body>
</html>

<script>
	$(() => {
		alert("JQuery 확인");
	}});
</script>