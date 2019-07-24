package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.medel.IolistDto;
import com.biz.iolist.medel.IolistVO;
import com.biz.iolist.service.IolistService;

@Controller
@RequestMapping(value="/iolist")
public class IolistController {
	@Autowired
	IolistService ioService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {

		List<IolistDto> iolist = ioService.selectJoin();
		model.addAttribute("IOLIST",iolist);
		
		return "ajax_body/iolist/list";
		
	}
	
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(@ModelAttribute IolistVO iolistVO,Model model) {
		
		int ret = ioService.insert(iolistVO);
		
		
		return "redirect:/iolist/list";
	}
	
	
	
}
