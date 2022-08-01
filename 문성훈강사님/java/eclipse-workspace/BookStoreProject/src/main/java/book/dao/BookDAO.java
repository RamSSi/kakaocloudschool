package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import book.vo.Book;

public class BookDAO {

	private DataSource ds;
	
	public BookDAO() throws Exception {
		
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");	
		
	}
	
	public ArrayList<Book> select(String keyword) throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공");
		
		String sql = "SELECT bisbn, btitle, bauthor, bprice, bimgurl FROM book WHERE btitle LIKE ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		System.out.println(keyword);
		ResultSet rs = pstmt.executeQuery();

		ArrayList<Book> list = new ArrayList<Book>();
		
		while(rs.next()) {
			// VO (book)를 생성하여 ArrayList에 추가
			
			Book book = new Book();
			book.setBtitle(rs.getString("btitle"));
			book.setBisbn(rs.getString("bisbn"));
			book.setBauthor(rs.getString("bauthor"));
			book.setBprice(rs.getInt("bprice"));
			book.setBimgurl(rs.getString("bimgurl"));
			
			list.add(book);
			System.out.println("book:" + book);
		}
		
		return list;
	}

}
