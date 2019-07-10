package com.biz.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.model.BookVO;

@Controller
public class BookController {

	@RequestMapping(value="book", method=RequestMethod.GET)
	public String book_insert(Model model) {
		
		model.addAttribute("BODY","BOOK_INSERT");
		return "home";
	}
	
	// old 버전
	@RequestMapping(value="book_old", method=RequestMethod.POST)
	public String book_insert(String b_title,String b_comp,String b_auth,String b_price,Model model) {
		
		model.addAttribute("b_title", b_title);
		model.addAttribute("b_comp", b_comp);
		model.addAttribute("b_auth", b_auth);
		model.addAttribute("b_price", b_price);
		model.addAttribute("BODY","BOOK_VIEW");
		return "home";
	}
	
	/*
	 * form으로 데이터를 받을때 
	 * input box에 설정된 변수들을 매개변수에 일일이 나열하지 않고
	 * 
	 * VO 클래스를 만들어서 @ModelAttribute로 받는다.
	 * 
	 * spring에서는
	 * form에서 보내는 데이터를 받을때
	 * form의 input box에 설정된 name 속성 값과 일치하는
	 * 필드(맴버변수)들을 선언하고, getter와 setter, 생성자가 있는
	 * VO를 만들어서 @ModelAttribute 매개변수로 사용하면
	 * 
	 * 자동으로 해당 클래스를 객체로 선언하고
	 * 각 필드의 값을 setting해서 사용할수 있도록구성한다.
	 * 
	 * input box에 입력되는 모든 값은 text(==String)이다.
	 * 매개변수로 값을 받을때 String이 아닌 다른 type으로 받으면
	 * String to type의 형변환을 시도한다.
	 * Ex) VO의 b_price가 int형일경우
	 * setB_price(Integer.valueOf(b_price)) 형식의 코드가 실행될것이다.
	 * 이때 b_price에 입력한 값이 숫자로 변환시키는데 문제가 있을경우
	 * (Exception이 발생할 경우)
	 * 서버는 브라우저에 400의 Http status(상태) 코드를 보낸다.
	 * 
	 * Integer.valueOf("AAA")
	 * Integer.valueOf("123AAA")
	 * Integer.valueOf("AAA123")
	 * Integer.valueOf("")
	 */
	@RequestMapping(value="book", method=RequestMethod.POST)
	public String book_insert(@ModelAttribute BookVO bookVO, Model model) {
		model.addAttribute("Book",bookVO);
		model.addAttribute("BODY","BOOK_VIEW");
		return "home";
	}
}
