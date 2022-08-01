package post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.vo.Member;
import post.vo.Post;

public class PostDAO {
	private DataSource ds;

	public PostDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}

	public ArrayList<Post> selectAll() throws Exception {
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공");

		String sql = "SELECT * FROM posts";

		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		ArrayList<Post> list = new ArrayList<Post>();

		while (rs.next()) {
			// VO (book)를 생성하여 ArrayList에 추가

			Post post = new Post();
			post.setNum(rs.getInt("pnum"));
			post.setTitle(rs.getString("ptitle"));
			post.setId(rs.getString("pid"));
			post.setContent(rs.getString("pcontent"));
			post.setDate(rs.getString("pdate"));
			post.setLike(rs.getInt("plike"));
			post.setView(rs.getInt("pview"));
			post.setComment(rs.getInt("pcmt"));

			list.add(post);
		}

		return list;
	}
	
	public Post selectOne(int postNum) throws SQLException {
		Connection con = ds.getConnection();
		System.out.println("connection 획득 성공");

		String sql = "SELECT * FROM posts WHERE pnum=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, postNum);
		ResultSet rs = pstmt.executeQuery();

		Post post = new Post();
		
		if (rs.next()) {
			post.setNum(rs.getInt("pnum"));
			post.setTitle(rs.getString("ptitle"));
			post.setId(rs.getString("pid"));
			post.setContent(rs.getString("pcontent"));
			post.setDate(rs.getString("pdate"));
			post.setLike(rs.getInt("plike"));
			post.setView(rs.getInt("pview"));
			post.setComment(rs.getInt("pcmt"));
		}

		return post;
	}
}