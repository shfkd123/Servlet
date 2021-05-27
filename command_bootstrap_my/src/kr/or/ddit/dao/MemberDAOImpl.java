package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public List<MemberVO> memberAllListPrint(SqlSession session) throws SQLException {
		List<MemberVO> memList = session.selectList("MemManage.memberAllListPrint");
		return memList;
	}

	@Override
	public int memberInfoInsert(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = session.insert("MemManage.memberInfoInsert", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int memberInfoUpdate(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("MemManage.memberInfoUpdate", mv);
		
		return cnt;
	}

	@Override
	public int memberInfoDelete(SqlSession session, MemberVO mv) throws SQLException {
		int cnt  = 0;
		
		cnt = session.delete("MemManage.memberInfoDelete", mv);
		
		return cnt;
	}

	@Override
	public MemberVO getMemberInfo(SqlSession session, String id) throws SQLException {
		MemberVO mv = session.selectOne("MemManage.getMemberInfo", id);
		return mv;
	}

	@Override
	public boolean checkMember(SqlSession session, MemberVO mv) throws SQLException {
		boolean chk = false;
		
		int cnt = session.selectOne("MemManage.checkMember", mv);
		
		if(cnt > 0){
			chk = true;
		}
		
		return chk;
	}

}
