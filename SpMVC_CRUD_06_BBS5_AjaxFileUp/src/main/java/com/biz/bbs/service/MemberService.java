package com.biz.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.biz.bbs.mapper.MemberDao;
import com.biz.bbs.model.MemberVO;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	MemberDao mDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public MemberVO login_id_check(String m_userid,String m_password) {
		// TODO 아이디 체크
		MemberVO memberVO = mDao.login_id_check(m_userid);
		if(memberVO != null) {
			// DB에 저장된 암호화된 비밀번호
			String cryptPassword = memberVO.getM_password();
			if(passwordEncoder.matches(m_password, cryptPassword)) {
				// 암호가 일치하면
				return memberVO;
			} 
		}
		return null;
	}

	public String check_id(String m_userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(MemberVO memberVO) {
		
		int ret = mDao.insert(memberVO);
		return ret;
	}

	public MemberVO login_id_check(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
