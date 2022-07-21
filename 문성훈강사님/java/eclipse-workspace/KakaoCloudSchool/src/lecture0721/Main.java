package lecture0721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			// 1. JDBC Driver Loading
			// MySQL 8.0부터는 아래의 class를 이용
			Class.forName("com.mysql.cj.jdbc.Driver");	// Loading할 Class 이름
			System.out.println("드라이버 로딩 성공!");
			
			
			// 2. Database 연결
			String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serviceTimezone=UTC&useSSL=false";
			// DBMS : jdbc:mysql://localhost:3306
			// Database : /sqldb
			con = DriverManager.getConnection(jdbcURL, "root", "1234");	// DB에서 데이터를 가져올 connection 객체
			System.out.println("데이터베이스 연결 성공!");
			
			
			String sql = "SELECT * FROM usertbl";
			// 3. Statement 생성
			stmt = con.createStatement();	// new 키워드가 아닌 connection을 통해 생성 (연결된 후 statement를 생성하는 것이므로)
			// statement를 이용하여 query를 db에 적용할 수 있음
			// PreparedStatement 생성
			pstmt = con.prepareStatement(sql);	// Java의 문자열(쿼리)을 DBMS가 사용할 수 있도록 미리 Encoding (속도면에서 일반 statement보다 빠름)
			
			// 4. Query 실행
			rs1 = stmt.executeQuery(sql);
			rs2 = pstmt.executeQuery();	// 이미 encoding된 sql 문장을 가지고 있음
			
			// 5. 결과 처리
			
			
			// 6. 사용한 자원 해제
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		} catch (SQLException e2) {
			System.out.println(e2);
			e2.printStackTrace();
		} finally {
			try {
				if (rs1 != null) rs1.close();
				if (rs2 != null) rs2.close();
				if (stmt != null) stmt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				System.out.println("연결 종료~");
			} catch (Exception e) {
				
			}
		}
	}
}
