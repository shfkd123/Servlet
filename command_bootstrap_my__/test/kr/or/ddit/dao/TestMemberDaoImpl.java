package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemberDaoImpl {
	private SqlSession session;
	private MemberDAO memDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memDAO = new MemberDAOImpl();
	}
	
	@Test
	public void testMemberAllListPrint() throws Exception{
		List<MemberVO> memList = memDAO.memberAllListPrint(session);
		Assert.assertEquals(7, memList.size());
		
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
