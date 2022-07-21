package lecture0721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainDelete {

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
			// 여러 DB를 연결하는 작업은 큰 부하가 걸림
			System.out.println("데이터베이스 연결 성공!");
			
			
			con.setAutoCommit(false);	// Auto Commit X -> 이 시점부터 Transaction 시작
			
			// preparedStatement는 IN Parameter 사용 가능
			// table 이름이나 예약어에는 사용 불가능, 값을 부텨하는 부분에 사용 가능
			String sql = "DELETE FROM buytbl WHERE userId = ?";
			// 3. Statement 생성
			// PreparedStatement 생성
			pstmt = con.prepareStatement(sql);	// Java의 문자열(쿼리)을 DBMS가 사용할 수 있도록 미리 Encoding (속도면에서 일반 statement보다 빠름)
			pstmt.setString(1, "BBK");
			
			
			// 4. Query 실행
			int result = pstmt.executeUpdate();
			
			
			// 5. 결과 처리
			System.out.println("총 " + result + "개의 행이 삭제되었습니다.");
			
			con.rollback();	// Transaction 종료, delete 작업이 취소된다.
			
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
