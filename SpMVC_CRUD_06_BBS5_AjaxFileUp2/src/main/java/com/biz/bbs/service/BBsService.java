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
		// 게시판 내용 저장
		int ret = bDao.insert(bbsReqDto);
		// 첨부파일 정보 저장
		int file_ret = afService.insert(bbsReqDto);
		
		return ret;
	}

	public BBsDto getcontent(long bbs_seq) {
		
		 BBsDto bbsDto = bDao.findBySeqForFile(bbs_seq);
		return bbsDto;
	}
	
	public int delete(long bbs_seq) {
		// 첨부 파일 삭제
//		int file_ret = afService.files_delete(bbs_seq);
		
		// 게시글을 삭제하면 두 테이블이 참조 무결성 관계이므로
		// 첨부파일목록은 자동으로 삭제된다.
		int ret = bDao.delete(bbs_seq);
		
		return ret;
	}
	
	public int update(BBsReqDto bbsReqDto) {
		int ret = bDao.update(bbsReqDto);
		
		return ret;
	}


	
}
