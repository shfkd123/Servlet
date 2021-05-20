package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MenuVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMenuDaoImpl {
	
	private SqlSession session;
	private MenuDAO menuDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		menuDAO = new MenuDAOImpl();
	}
	
	@Test
	public void testSelectMainMenu() throws Exception{
		List<MenuVO> menuList = menuDAO.selectMainMenu(session);
		Assert.assertEquals(5, menuList.size()); //메뉴 개수 5개나와서 사이즈를 5로 한다. 5개 나오면 성공이다.
	}
	
/*	@Test
	public void testselectSubMenu(String mCode)throws Exception{
		List<MenuVO> menuList = menuDAO.selectSubMenu(session, mCode);
		Assert.assertEquals();
	}

	@Test
	public void testselectMenuByMcode(String mCode)throws Exception{
		MenuVO menu = menuDAO.selectMenuByMcode(session, mCode);
		Assert.assertEquals();
	}*/
	
	@After
	public void coplete() {
		session.rollback();
		session.close();
	}
	
}
