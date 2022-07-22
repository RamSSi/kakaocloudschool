package lecture0722.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 네이버 개발자는 UserDAO method를 이용하기 위해
// subclass를 작성
public class NUserDAO extends UserDAO {
	
	@Override
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_URL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		Connection con = DriverManager.getConnection(jdbc_URL, "root", "1234");	// 해당 계정을 이용하여 DB에 접근하면 연결 성공!
		
		return con;
	}
}
