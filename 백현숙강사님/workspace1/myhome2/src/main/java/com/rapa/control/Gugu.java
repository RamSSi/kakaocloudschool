package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

@WebServlet("/gugu")
public class Gugu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int dan = Integer.parseInt(req.getParameter("dan"));
//		String result = "";
		
		int dan = Integer.parseInt(CommonUtil.nullToValue(req.getParameter("dan"), "2"));
		System.out.println(dan);
		String result = "";
		
		for (int i=1; i<10; i++) {
			result += "<div>" + dan + "*" + i + "=" + dan*i + "</div>";
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(result);
		out.println("</body>");
		out.println("</html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
