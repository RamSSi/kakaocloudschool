package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/account")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("userName");
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");

		
		Member member = new Member();
		
		member.setName(name);
		member.setId(id);
		member.setPw(pw);

		
		MemberService memberService = new MemberService();
		boolean success = memberService.signup(member);
		
		if (success) {
			response.sendRedirect("/board/member/login.html");

		} else {
			try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('회원가입에 실패하였습니다.');history.go(-1);</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
			response.sendRedirect("/board/member/account.html");
		}
	}

}
