package kr.or.ddit.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {
	
	//회원정보 조회
	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
}
