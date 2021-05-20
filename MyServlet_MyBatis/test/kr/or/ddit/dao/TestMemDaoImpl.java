package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberManagementVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemDaoImpl {
	
	private SqlSession session;
	private MemberManagementDAO memDao;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memDao = new MemberManagementDAOImpl();
	}
	
	@Test
	public void testmemberAllListPrint() throws Exception{
		List<MemberManagementVO> memList = memDao.memberAllListPrint(session);
		Assert.assertEquals(2, memList.size());
	}

	@Test
	public void testmemberInfoInsert(MemberManagementVO mv) throws Exception{
		int cnt = 0;
		
		Object obj = memDao.memberInfoInsert(session, mv);
		
		if(obj == null) {
			cnt = 1;
		}
		Assert.assertEquals(1, cnt);
	}

	
	@After
	public void coplete() {
		session.rollback();
		session.close();
	}
	
}
