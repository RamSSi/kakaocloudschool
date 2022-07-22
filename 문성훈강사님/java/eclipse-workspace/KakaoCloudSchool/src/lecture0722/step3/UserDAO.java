package lecture0722.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDAO() {
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	// 사용자 정보를 받아 DB에 insert
	public void insert(User user) throws ClassNotFoundException, SQLException {	// method를 호출한 곳으로 예외를 던짐
		// try ~ catch를 사용하지 않음 -> 호출한 곳에서 예외처리
		
		Connection con = simpleConnectionMaker.makeNewConnection();
		
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

		Connection con = simpleConnectionMaker.makeNewConnection();
		
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
