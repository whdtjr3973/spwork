package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {
	
	public List<BookVO> selectAll();
	public BookVO findBySeq(long b_seq);
	public List<BookVO> findByTitle(String b_title);
	public int insert();
	
	public int update();
	public int delete(long b_seq);

}
