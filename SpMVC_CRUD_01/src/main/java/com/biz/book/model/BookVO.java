package com.biz.book.model;

public class BookVO {

	private long b_seq;// NUMBER PRIMARY KEY,
	private String b_title;// nVARCHAR2(100),
	private String b_comp;// nVARCHAR2(50),
	private String b_author;// nVARCHAR2(50),
    private int b_price;// NUMBER
    
    
    
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVO(long b_seq, String b_title, String b_comp, String b_author, int b_price) {
		super();
		this.b_seq = b_seq;
		this.b_title = b_title;
		this.b_comp = b_comp;
		this.b_author = b_author;
		this.b_price = b_price;
	}
	public long getB_seq() {
		return b_seq;
	}
	public void setB_seq(long b_seq) {
		this.b_seq = b_seq;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_comp() {
		return b_comp;
	}
	public void setB_comp(String b_comp) {
		this.b_comp = b_comp;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	@Override
	public String toString() {
		return "BookVO [b_seq=" + b_seq + ", b_title=" + b_title + ", b_comp=" + b_comp + ", b_author=" + b_author
				+ ", b_price=" + b_price + "]";
	}
	
    
}
