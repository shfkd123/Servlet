package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	
	//회원정보 조회
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
	
	//회원리스트 조회
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException;
	
	
}
