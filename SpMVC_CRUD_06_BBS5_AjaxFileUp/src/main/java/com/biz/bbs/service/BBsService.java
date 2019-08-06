package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BBsDao;
import com.biz.bbs.model.BBsDto;
import com.biz.bbs.model.BBsReqDto;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BBsService {
	@Autowired
	AjaxFileService afService;
	@Autowired
	BBsDao bDao;
	
	public List<BBsDto> bbsList(){
		// List<BBsVO> bbsList = bDao.selectAll();
		List<BBsDto> bbsList = bDao.selectAll();
		return bbsList;
		
	}
	public List<BBsDto> bbsListForFile(){
		List<BBsDto> bbsList = bDao.selectAllForFile();
		
			return bbsList;
	}

	public int insert(BBsReqDto bbsReqDto) {
		int ret = bDao.insert(bbsReqDto);
		
		return ret;
	}

	public BBsDto getcontent(long bbs_seq) {
		
		 BBsDto bbsDto = bDao.findBySeqForFile(bbs_seq);
		return bbsDto;
	}
	
	public int delete(long bbs_seq) {

		int ret = bDao.delete(bbs_seq);
		
		return ret;
	}
	
	public int update(BBsReqDto bbsReqDto) {
		int ret = bDao.update(bbsReqDto);
		
		return ret;
	}


	
}
