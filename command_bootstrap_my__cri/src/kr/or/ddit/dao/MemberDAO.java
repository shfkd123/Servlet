package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	//회원 정보 조회
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException;

	//전체 회원 리스트 출력
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException;
	
	
	
	//회원 정보 등록
	public int memberInfoInsert(SqlSession session, MemberVO mv) throws SQLException;
	
	//회원 정보 수정
	public int memberInfoUpdate(SqlSession session, MemberVO mv) throws SQLException;
	
	//회원 정보 삭제
	public int memberInfoDelete(SqlSession session, MemberVO mv) throws SQLException;
	
	
	//회원이 존재하는지 여부 판단
	public boolean checkMember(SqlSession session, MemberVO mv) throws SQLException;
}
