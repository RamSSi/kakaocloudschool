package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sX = CommonUtil.nullToValue(req.getParameter("x"));
		String sY = CommonUtil.nullToValue(req.getParameter("y"));
		int x = Integer.parseInt(sX);
		int y = Integer.parseInt(sY);
		int oper = Integer.parseInt(req.getParameter("oper"));
		int result = 0;
		String op="";
		
		if (oper == 1) {
			result = x + y;
			op = "+";
		}
		else if (oper == 2) {
			result = x - y;
			op = "-";
		}
		else if (oper == 3) {
			result = x * y;
			op = "*";
		}
		else if (oper == 4) {
			result = x / y;
			op = "/";
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<meta charset='utf-8'>");
		out.println("<body>");
		out.println("<h1>" + x + op + y + "=" + result + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
