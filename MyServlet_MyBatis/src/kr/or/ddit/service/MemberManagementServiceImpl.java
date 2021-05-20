package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MemberManagementDAO;
import kr.or.ddit.dao.MemberManagementDAOImpl;
import kr.or.ddit.dto.MemberManagementVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberManagementServiceImpl implements MemberManagementService {

	private MemberManagementDAO memDao = new MemberManagementDAOImpl();
	public void setMemDao(MemberManagementDAO memDao) {
		this.memDao = memDao;
	}
	
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory SqlSessionFactory) {
		this.sqlSessionFactory = SqlSessionFactory;
	}
	
	@Override
	public List<MemberManagementVO> memberAllListPrint() throws SQLException {
		List<MemberManagementVO> memList = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		memList = memDao.memberAllListPrint(session);
		
		session.close();
		
		return memList;
	}

	@Override
	public int memberInfoInsert(MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.memberInfoInsert(session, mv);
		
		session.close();
		
		return cnt;
	}

	@Override
	public int memberInfoUpdate(MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.memberInfoUpdate(session, mv);
		
		session.close();
		
		return cnt;
	}

	@Override
	public int memberInfoDelete(MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		cnt = memDao.memberInfoDelete(session, mv);
		
		session.close();
		
		return cnt;
	}

	@Override
	public MemberManagementVO getMemberInfo(String memId) throws SQLException {
		
		MemberManagementVO mv = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		mv = memDao.getMemberInfo(session, memId);
		
		session.close();
		
		return mv;
		
	}

	@Override
	public boolean checkMember(MemberManagementVO mv) throws SQLException {
		boolean chk = false;
		
		SqlSession session = sqlSessionFactory.openSession();
		
		chk = memDao.checkMember(session, mv);
		
		session.close();
		
		return chk;
	}

}
