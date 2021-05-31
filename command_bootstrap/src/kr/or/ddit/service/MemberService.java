package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;

public interface MemberService {
	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	//회원정보조회
	MemberVO getMember(String id) throws SQLException;
	
	//회원리스트
	List<MemberVO> getMemberList() throws SQLException;
	List<MemberVO> getMemberList(Criteria cri) throws SQLException; //오버로딩 기능의 확장 
	
	
}
