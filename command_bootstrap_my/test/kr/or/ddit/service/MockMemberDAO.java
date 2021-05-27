package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dto.MemberVO;

public class MockMemberDAO implements MemberDAO {

	@Override
	public List<MemberVO> memberAllListPrint(SqlSession session) throws SQLException {

		return null;
	}

	@Override
	public int memberInfoInsert(SqlSession session, MemberVO mv) throws SQLException {
		
		return 0;
	}

	@Override
	public int memberInfoUpdate(SqlSession session, MemberVO mv) throws SQLException {
		
		return 0;
	}

	@Override
	public int memberInfoDelete(SqlSession session, MemberVO mv) throws SQLException {
		
		return 0;
	}

	@Override
	public MemberVO getMemberInfo(SqlSession session, String id) throws SQLException {
		
		return null;
	}

	@Override
	public boolean checkMember(SqlSession session, MemberVO mv) throws SQLException {
		
		return false;
	}

}
