package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {
	public List<BookVO> selectAll();
//	public BookVO findBYseq(long seq);
//	
//	public String insert(BookVO vo);
//	public String update(BookVO vo);
//	public int delete(long seq);

}
