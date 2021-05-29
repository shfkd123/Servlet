package kr.or.ddit.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MenuVO;

public class TestOracleMyBatisSqlSessionFactory {

   /**
    * Test는 여러 개이지만 Before, After는 하나다.
    * before, test, after 셋 모두 public이며 return타입(void) 없어야 함.
    */
   
   private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
   private SqlSession session;
   
   @Before
   public void openSession() {
      session = factory.openSession();
   }
   
   /**
    * Session이 Null 인지 TEST
    * @throws Exception
    */
   @Test
   public void testSqlSession() throws Exception{
      Assert.assertNotNull(session.getConnection());
   }
   
   /**
    * SQL문이 잘되었는지 TEST
    */
   @Test
   public void testSQL() {
      SqlSession session = factory.openSession();
      MenuVO menu = session.selectOne("Menu-Mapper.selectMenuByMcode", "M010100");
      Assert.assertEquals("회원목록", menu.getMname());
   }
   
   /**
    * 사용한 세션을 반납
    */
   @After
   public void closeSession () {
      session.close();
   }
   
   
}