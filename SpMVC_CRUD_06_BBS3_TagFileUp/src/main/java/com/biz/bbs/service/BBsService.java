package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BBsDao;
import com.biz.bbs.model.BBsDto;
import com.biz.bbs.model.BBsVO;
import com.biz.bbs.model.FileVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class BBsService {
	
	@Autowired
	FileService fileService;
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

	/*
	 * 글쓰기를 수행할때 file을 같이 upload를 수행하면
	 * 해당하는 글의 bbs_seq를 조회하여
	 * file table에 저장할떄 같이 저장을 수행해줘야 한다.
	 * 
	 * 1.게시글을 저장하고
	 * 2.게시글의 bbs_seq를 조회하여
	 * 3.파일정보를 insert할떄 해당하는 bbs_seq를 같이 저장해주어야 한다.
	 * 그래야 게시글을 조회할떄 해당하는 파일들을 같이 조회할수 있다.
	 */
	public int insert(BBsVO bbsVO) {
		// 1. 게시글을 저장
		// 저장후에는 bbsVO.bbs_seq에 새로 생성된 PK값이 담겨있다.
		int ret = bDao.insert(bbsVO);
		if(bbsVO.getBbs_files().size() > 0 &&
				!bbsVO.getBbs_files().get(0).getOriginalFilename().isEmpty()) {
			
			fileService.uploadFileList(bbsVO);
			//fileService.fileListInsert(fileList);
		}
		
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
	
	public int update(BBsVO bbsVO) {
		int ret = bDao.update(bbsVO);
		
		if(bbsVO.getBbs_files().size() > 0 &&
				!bbsVO.getBbs_files().get(0).getOriginalFilename().isEmpty()) {
			
			fileService.uploadFileList(bbsVO);
		}			
		return ret;
	}


	
}
