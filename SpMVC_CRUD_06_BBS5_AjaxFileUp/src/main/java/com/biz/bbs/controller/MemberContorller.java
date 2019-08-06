package com.biz.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.bbs.model.MemberVO;
import com.biz.bbs.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberContorller {
	@Autowired
	MemberService mService;
	
	@ResponseBody
	@RequestMapping(value="/check_id", method=RequestMethod.GET)
	public String check_id(@RequestParam String m_userid, Model model) {
		
		return mService.check_id(m_userid);
		
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String Login(Model model) {
		return "body/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String Join(Model model) {
		
		return "body/join";
		
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO, Model model) {
		
		int ret = mService.insert(memberVO);
		return "redirect:/";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO memberVO, Model model, HttpSession httpSession) {
		
		MemberVO re_memberVO = mService.login_id_check(memberVO);
		if(re_memberVO == null) {
			model.addAttribute("LOGIN", "FAIL");
			return "redirect:/";
		} else {
			httpSession.setAttribute("LOGIN_USER", re_memberVO);
			return "redirect:/";
		}
		
	}
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(Model model, HttpSession httpSession) {
		
		return "redirect:/";
	}
	
}
