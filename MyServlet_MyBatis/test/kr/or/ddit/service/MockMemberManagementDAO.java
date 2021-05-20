package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dao.MemberManagementDAO;
import kr.or.ddit.dto.MemberManagementVO;

public class MockMemberManagementDAO implements MemberManagementDAO{

	@Override
	public List<MemberManagementVO> memberAllListPrint(SqlSession session) throws SQLException {
		List<MemberManagementVO> memList = null;
		
		MemberManagementVO member = new MemberManagementVO();
		
		return null;
	}

	@Override
	public int memberInfoInsert(SqlSession session, MemberManagementVO mv) throws SQLException {
		
		return 0;
	}

	@Override
	public int memberInfoUpdate(SqlSession session, MemberManagementVO mv) throws SQLException {
		
		return 0;
	}

	@Override
	public int memberInfoDelete(SqlSession session, MemberManagementVO mv) throws SQLException {
		
		return 0;
	}

	@Override
	public MemberManagementVO getMemberInfo(SqlSession session, String memId) throws SQLException {
		
		return null;
	}

	@Override
	public boolean checkMember(SqlSession session, MemberManagementVO mv) throws SQLException {
		
		return false;
	}

}
