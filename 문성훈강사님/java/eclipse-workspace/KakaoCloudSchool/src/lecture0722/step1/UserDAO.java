package lecture0722.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	// 사용자 정보를 받아 DB에 insert
	public void insert(User user) throws ClassNotFoundException, SQLException {	// method를 호출한 곳으로 예외를 던짐
		// try ~ catch를 사용하지 않음 -> 호출한 곳에서 예외처리
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_URL = "jdbc:mysql://:localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con = DriverManager.getConnection(jdbc_URL, "root", "1234");	// 해당 계정을 이용하여 DB에 접근하면 연결 성공!
		
		String sql = "INSERT INTO users VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	public User select(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_URL = "jdbc:mysql://:localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con = DriverManager.getConnection(jdbc_URL, "root", "1234");	// 해당 계정을 이용하여 DB에 접근하면 연결 성공!
		
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));	// getString("column");
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}

}
