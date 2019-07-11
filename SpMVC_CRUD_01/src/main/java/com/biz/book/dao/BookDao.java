package com.biz.book.dao;



import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {

	public List<BookVO> selectAll();
	public BookVO findBySeq(long b_seq);
	
	public List<BookVO> findByTitle(String b_title);
	
	public void insert(BookVO bookVO);
	public void update(BookVO bookVO);
	public void delete(long b_seq);
}
