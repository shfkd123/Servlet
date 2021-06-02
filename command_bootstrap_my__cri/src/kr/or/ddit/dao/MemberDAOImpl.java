package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		MemberVO mv =  session.selectOne("Member-Mapper.selectMemberById", id);
		return mv;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memList = session.selectList("Member-Mapper.memberAllListPrint");
		return memList;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memList = session.selectList("Member-Mapper.memberAllListPrint", null, rowBounds);
		return memList;
	}
	
	@Override
	public int memberInfoInsert(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = session.insert("Member-Mapper.memberInfoInsert", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int memberInfoUpdate(SqlSession session, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("Member-Mapper.memberInfoUpdate", mv);
		
		return cnt;
	}

	@Override
	public int memberInfoDelete(SqlSession session, MemberVO mv) throws SQLException {
		int cnt  = 0;
		
		cnt = session.delete("Member-Mapper.memberInfoDelete", mv);
		
		return cnt;
	}


	@Override
	public boolean checkMember(SqlSession session, MemberVO mv) throws SQLException {
		boolean chk = false;
		
		int cnt = session.selectOne("Member-Mapper.checkMember", mv);
		
		if(cnt > 0){
			chk = true;
		}
		
		return chk;
	}

}
