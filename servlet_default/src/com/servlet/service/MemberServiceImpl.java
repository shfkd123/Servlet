package com.servlet.service;

import java.sql.SQLException;

import com.servlet.dao.MemberDAO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

import member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO; // = MemberDAOImpl.getInstance();
	@Override
	public MemberVO login(String memid, String memPass) 
			throws NotFoundIDException, InvalidPasswordException, SQLException {
		
		MemberVO member = null;
		
		try {
			member = memberDAO.selectMemberByID(memid);
		}catch(SQLException e) {
			//Exception에 대한 처리 구문 필요
			e.printStackTrace();
			throw e;
		}
		if(member != null) {
			if(memPass.equals(member.getMemPass())) { //로그인 성공
				return member;
			}else { //패스워드 불일치
				throw new InvalidPasswordException();
			}
		}else { //아이디 불일치
			throw new NotFoundIDException();
		}
	}

}

