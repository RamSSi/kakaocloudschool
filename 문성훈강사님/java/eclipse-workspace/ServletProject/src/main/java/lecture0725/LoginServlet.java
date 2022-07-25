package lecture0725;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력을 받음
		// 주의✔ 
		// 입력을 받을 때 사용되는 Stream의 encoding : ISO-8859-1
		// 한글 데이터를 전달받으려면 데이터 가공 필요
		// 1) GET 방식 : Tomcat의 InputStream Encoding 변경
		// 2) POST 방식 : request.setCharacterEncoding("EUC-KR");
		
		String email = request.getParameter("userEmail");
		String pw = request.getParameter("userPassword");
		
		System.out.println(email + ", " + pw);
		
		
		// 2. 로직 처리
		
		String jdbcURL = "jdbc:mysql://localhose:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean loginStatus = false;
		
		try {
			con = DriverManager.getConnection(jdbcURL, "root", "1234");
			String sql = "SELECT * FROM tmpuser where email=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  email);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginStatus = true;
			}
			
		} catch (Exception e) {
			
		} finally {
			// close 처리 진행
		}
		
		
		
		// 3. 출력 처리
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.println("<html><head><body>");
		if (loginStatus) {
			out.println("환영합니다.");
		} else {
			out.println("로그인에 실패했습니다.");
		}
		out.println("</body></head></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
