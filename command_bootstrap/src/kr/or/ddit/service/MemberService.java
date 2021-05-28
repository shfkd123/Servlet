package kr.or.ddit.service;

import java.sql.SQLException;

import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;

public interface MemberService {
	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	//회원정보조회
	MemberVO getMember(String id) throws SQLException;
	
	
}
