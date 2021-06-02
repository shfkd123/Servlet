package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

public interface MemberService {

	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;

	//회원정보조회
	public MemberVO getMember(String id) throws SQLException;
	
	//회원리스트
	List<MemberVO> getMemberList() throws SQLException; //전체리스트 
	List<MemberVO> getMemberList(Criteria cri) throws SQLException; 
	
	public int memberInfoInsert(MemberVO mv) throws SQLException;

	public int memberInfoUpdate(MemberVO mv) throws SQLException;
	
	public int memberInfoDelete(MemberVO mv) throws SQLException;
	
	public boolean checkMember(MemberVO mv) throws SQLException;
	
}
