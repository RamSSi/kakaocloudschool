package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import comment.vo.Comment;


public class CommentDAO {
private DataSource ds;
	
	public CommentDAO() throws Exception {
		
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/MySQLDB");	
		
	}
	
	public ArrayList<Comment> select(int num) throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공");
		
		String sql = "SELECT * FROM comments WHERE cnum = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + num + "%");
		ResultSet rs = pstmt.executeQuery();

		ArrayList<Comment> list = new ArrayList<Comment>();
		
		while(rs.next()) {			
			Comment comment = new Comment();
			comment.setId(rs.getString("cid"));
			comment.setNum(rs.getInt("cnum"));
			comment.setContent(rs.getString("ccontent"));
			comment.setDate(rs.getString("cdate"));
			System.out.println(comment);
			list.add(comment);
		}
		
		return list;
	}
}
