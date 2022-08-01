package view.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;
import post.service.PostService;
import post.vo.Post;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/view")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		int pNum = Integer.parseInt(request.getParameter("postNum"));
		
		PostService pservice = new PostService();
		Post post = null;
		
		CommentService cservice = new CommentService();
		ArrayList<Comment> cmt = new ArrayList<Comment>();
		
		try {
			post = pservice.getPost(pNum);
			cmt = cservice.getComment(pNum);
			System.out.println(cmt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("post/view.jsp");
		request.setAttribute("comment", cmt);
		request.setAttribute("post", post);
		request.setAttribute("member", member);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
