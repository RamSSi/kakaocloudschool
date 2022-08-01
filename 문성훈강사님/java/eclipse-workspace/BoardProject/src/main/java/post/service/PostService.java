package post.service;

import java.sql.SQLException;
import java.util.ArrayList;

import post.dao.PostDAO;
import post.vo.Post;

public class PostService {
	public ArrayList<Post> getAllPost() {
		ArrayList<Post> list = null;
		try {
			PostDAO dao = new PostDAO();
			list = dao.selectAll();
			
		} catch (Exception e) {
			System.out.println(e);
		
		}
		
		return list;
	}
	
	public Post getPost(int pNum) throws Exception {
		Post post = null;

			try {
				PostDAO dao = new PostDAO();
				post = dao.selectOne(pNum);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return post;
	}
}
