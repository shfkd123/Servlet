package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memDao = new MemberDAOImpl();
	public void setMemDao(MemberDAO memDao) {
		this.memDao = memDao;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory SqlSessionFactory) {
		this.sqlSessionFactory = SqlSessionFactory;
	}
	
	@Override
	public List<MemberVO> memberAllListPrint() throws SQLException {
		List<MemberVO> memList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		memList = memDao.memberAllListPrint(session);
		
		session.close();
		
		return memList;
	}

	@Override
	public int memberInfoInsert(MemberVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.memberInfoInsert(session, mv);
		
		session.close();
		
		return cnt;
	}

	@Override
	public int memberInfoUpdate(MemberVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.memberInfoUpdate(session, mv);
		
		session.close();
		
		return cnt;
	}

	@Override
	public int memberInfoDelete(MemberVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.memberInfoDelete(session, mv);
		
		session.close();
		
		return cnt;
	}

	@Override
	public MemberVO getMemberInfo(String id) throws SQLException {
		
		MemberVO mv = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		mv = memDao.getMemberInfo(session, id);
		
		session.close();
		
		return mv;
		
	}

	@Override
	public boolean checkMember(MemberVO mv) throws SQLException {
		boolean chk = false;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		chk = memDao.checkMember(session, mv);
		
		session.close();
		
		return chk;
	}

}
