package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

public interface MemberService {
	
	List<MemberVO> memberAllListPrint() throws SQLException;
	
	public int memberInfoInsert(MemberVO mv) throws SQLException;

	public int memberInfoUpdate(MemberVO mv) throws SQLException;
	
	public int memberInfoDelete(MemberVO mv) throws SQLException;
	
	public MemberVO getMember(String id) throws SQLException;
	
	public boolean checkMember(MemberVO mv) throws SQLException;
	
	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
}
