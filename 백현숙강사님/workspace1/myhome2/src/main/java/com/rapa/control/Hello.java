package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
// http://127.0.0.1:8080/myhome2/hello
@WebServlet("/hello")	// tomcat7부터 바뀜  > 접근할 수 없는 servlet을 호출해주는 메서드
public class Hello extends HttpServlet {	// HttpServlet을 상속받은 클래스를 모두 실행시켜주는 메서드
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();	// 부모 생성자
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // GET 방식으로 전달될 때 doGet 호출
    // request 객체 - client(브라우저)의 요청을 받아오는 객체, was가 만듦
    // response 객체 - server 측에서 client에게 응답을 보낼 때 사용하는 객체
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	System.out.println("doget 콘솔창");	// 사용자에겐 보이지 않고 콘솔창에만 출력되는 메서드(System.out.println)
    	PrintWriter out = response.getWriter();
    	
    	out.print("<html>");
    	out.print("<meta charset='utf-8'>");
    	out.print("<body>");
    	out.print("<h1>hello</h1>");
    	out.print("<h1>안녕하세요</h1>");
    	out.print("</body>");
    	out.print("</html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// POST 방식으로 전달될 때 doPost 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost 콘솔창");
		doGet(request, response);	// doGet을 호출해 특별한 상황이 아니라면 GET, POST 모두 처리
	}

}
