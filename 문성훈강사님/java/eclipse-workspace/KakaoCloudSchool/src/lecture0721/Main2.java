package lecture0721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
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
			
			
			String sql = "SELECT userID, name, addr FROM usertbl";
			// 3. Statement 생성
			// PreparedStatement 생성
			pstmt = con.prepareStatement(sql);	// Java의 문자열(쿼리)을 DBMS가 사용할 수 있도록 미리 Encoding (속도면에서 일반 statement보다 빠름)
			
			// 4. Query 실행
			rs = pstmt.executeQuery();	// 이미 encoding된 sql 문장을 가지고 있음
			
			// 5. 결과 처리
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String addr  = rs.getString(3);
				System.out.println(id + ", " + name + ", " + addr);
			}
			
			// 6. 사용한 자원 해제
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		} catch (SQLException e2) {
			System.out.println(e2);
			e2.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				System.out.println("연결 종료~");
			} catch (Exception e) {
				
			}
		}
	}
}
