package book.service;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.Book;

public class BookService {

	public ArrayList<Book> searchByKeyword(String keyword) {
		
		ArrayList<Book> list = null;
		
		// 로직 처리
		
		try {
			BookDAO dao = new BookDAO();
			list = dao.select(keyword);	// dao.select는 검색 결과를 반환해줌
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return list;
	}

}
