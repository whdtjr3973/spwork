package com.biz.bbs.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.model.BBsVO;
import com.biz.bbs.service.BBsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/bbs")
public class BBsController {

	@Autowired
	BBsService bbsService;
	
	/*
	 * 현재의 controller내의 어떤 메서드에서
	 * BBsVO를 객체로 취급하여 값을 setter, getter하려고 시도할때
	 * 만약 객체가 초기화 되지 않아 NullPointException이 발생하려고 하면
	 * 이 메서드가 자동으로 호출되어 bbsVO객체를 생성및 초기화 해준다.
	 */
	@ModelAttribute("bbsVO")
	public BBsVO newBBsVO() {
		
		return new BBsVO();
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String list(Model model) {
		List<BBsVO> bbsList = bbsService.bbsList();
		model.addAttribute("LIST", bbsList);
		model.addAttribute("BODY", "BBS_LIST");
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model) {
		
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		
		
		bbsVO.setBbs_date(ld.toString());
		bbsVO.setBbs_time(lt.toString());
		model.addAttribute("bbsVO", bbsVO);
		
		model.addAttribute("BODY", "BBS_WRITE");
		return "home";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write_up(@ModelAttribute BBsVO bbsVO,
							@RequestParam("bbs_file") List<MultipartFile> files,
							Model model) {
//		List<MultipartFile> fileList = files.getFiles("bbs_file");
//		log.debug("파일개수:" + files.size());
//		
//		for(MultipartFile f : files) {
//			log.debug("파일명:" + f.getOriginalFilename());
//		}
		
		int ret = bbsService.insert(bbsVO);
		return "redirect:/bbs";
		
	}
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@RequestParam long bbs_seq,Model model) {
		
		BBsVO bbsVO = bbsService.getcontent(bbs_seq); 
		
		model.addAttribute("BBS",bbsVO);
		model.addAttribute("BODY","BBS_VIEW");
		
		return "home";
	}
	
}
