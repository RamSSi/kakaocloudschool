<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int x = Integer.parseInt(request.getParameter("xvalue"));
int y = Integer.parseInt(request.getParameter("yvalue"));
int op = Integer.parseInt(request.getParameter("op"));

int result = 0;

if(op == 1) {
	result = x + y;
}
else if (op == 2) {
	result = x - y;
}
else if (op == 3) {
	result = x * y;
}
else if (op == 4) {
	if (x == 0) { 
		result = 0;
	}
	result = x / y;
}
%>
{"result":"success", "value": "<%=result%>"}
