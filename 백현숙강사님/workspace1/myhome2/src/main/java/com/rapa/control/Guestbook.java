package com.rapa.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

/**
 * Servlet implementation class Guestbook
 */
@WebServlet("/guest")
public class Guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guestbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonUtil.nullToValue(request.getParameter("cmd"), "list");
		if (cmd.equals("info")) {
			getInfo(request, response);
		}
		else if (cmd.equals("list")) {
			getList(request, response);
		}
	}
	
	void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 각 페이지에서 요청을 받으면 그 페이지가 바뀜, 이후 받은 요청은 전달이 안되는데 RequestDispatcher를 이용하면 요청이 다른 페이지로 이전됨
		// 원하는 jsp 페이지를 매개변수로 전달하면 그 페이지로 이동 시켜준다.
		// 부가적인 정보를 저장해서 jsp로 전달 가능
		// request.setAttribute(key, value); : request 객체에 부가적인 정보를 저장
		request.setAttribute("username",  "홍길동");
		request.setAttribute("age", 23);
		request.setAttribute("phone", "010-0000-0001");
		// setParameter 없음, parameter는 무조건 form 태그를 통해서 전달되기 때문에 프로그램으로 추가할 수 있는 방법은 없음
				
				
		RequestDispatcher rd = request.getRequestDispatcher("/guest.jsp");
		rd.forward(request, response);	// jsp 페이지 호출
	}
	
	void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		// List - 추상 클래스
		// ArrayList - 구현 클래스

		list.add("작약");
		list.add("모란");
		list.add("국화");
		list.add("접시꽃");
		list.add("백일홍");
		list.add("천일홍");
		list.add("은방울꽃");
		
		request.setAttribute("flowerList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
	}
}
