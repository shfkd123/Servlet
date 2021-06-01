package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MenuVO;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestNoticeDaoImpl {
   
   private SqlSession session;
   private NoticeDAO noticeDAO;
   
   /**
    * 테스트 할 때는 Rollback 해야 하기 때문에 auto-commit을 없애야 함. => false
    */
   @Before
   public void init() {
      session = new OracleMyBatisSqlSessionFactory().openSession(false);
      noticeDAO = new NoticeDAOImpl();
   }

   
   /**
    * 공지 게시글 
    * @throws Exception
    */
   @Test
   public void testSelectNoticeList() throws Exception{
      List<NoticeVO> noticeList = noticeDAO.NoticeList(session);
      Assert.assertEquals(22, noticeList.size());
   }
   
   @After
   public void complete() {
      session.rollback();
      session.close();
   }
}