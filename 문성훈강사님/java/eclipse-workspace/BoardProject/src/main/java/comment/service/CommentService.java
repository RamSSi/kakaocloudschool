package comment.service;

import java.util.ArrayList;

import comment.dao.CommentDAO;
import comment.vo.Comment;

public class CommentService {

	public ArrayList<Comment> getComment(int num) {
		ArrayList<Comment> list = null;
		
		// 로직 처리
		
		try {
			CommentDAO dao = new CommentDAO();
			list = dao.select(num);	// dao.select는 검색 결과를 반환해줌
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return list;
	}
	
}
