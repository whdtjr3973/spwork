package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {
	public List<BookVO> selectAll();
	public BookVO findByseq(long seq);
	
	// 도서명으로 검색하기
	public List<BookVO> findByTitle(String b_title);
	public List<BookVO> findByComp(String b_comp);
	public List<BookVO> findByAuthor(String b_author);
	
	public String insert(BookVO vo);
	public String update(BookVO vo);
	public int delete(long seq);

}
