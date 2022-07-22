package lecture0722.step5;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ConnectionMaker connectionMaker = new NUserDAO();
		
		UserDAO dao = new UserDAO(connectionMaker);
		
		User user = new User();
		user.setId("1");
		user.setName("홍길동");
		user.setPassword("1234");
	
		dao.insert(user);
		
		System.out.println("새로운 사용자 등록");
		
		User user2 = dao.select("1");
		System.out.println(user2.getName() + ", " + user2.getPassword());
	}

}
