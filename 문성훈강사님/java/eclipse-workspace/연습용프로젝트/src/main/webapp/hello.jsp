<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("userName"); // 내장 객체가 존재하기 때문에 request 사용 가능 %>
	받은 데이터는 : <%= name %>
	
</body>
</html>