package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberManagementVO;

public class MemberManagementDAOImpl implements MemberManagementDAO{

	@Override
	public List<MemberManagementVO> memberAllListPrint(SqlSession session) throws SQLException {
		List<MemberManagementVO> memList = session.selectList("MemManage.memberAllListPrint");
		return memList;
	}

	@Override
	public int memberInfoInsert(SqlSession session, MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = session.insert("MemManage.memberInfoInsert", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int memberInfoUpdate(SqlSession session, MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("MemManage.memberInfoUpdate", mv);
		
		return cnt;
	}

	@Override
	public int memberInfoDelete(SqlSession session, MemberManagementVO mv) throws SQLException {
		int cnt  = 0;
		
		cnt = session.delete("MemManage.memberInfoDelete", mv);
		
		return cnt;
	}

	@Override
	public MemberManagementVO getMemberInfo(SqlSession session, String memId) throws SQLException {
		MemberManagementVO mv = session.selectOne("MemManage.getMemberInfo", memId);
		return mv;
	}

	@Override
	public boolean checkMember(SqlSession session, MemberManagementVO mv) throws SQLException {
		boolean chk = false;
		
		int cnt = session.selectOne("MemManage.checkMember", mv);
		
		if(cnt > 0){
			chk = true;
		}
		
		return chk;
	}

}
