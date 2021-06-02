package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.NoticeDAO;
import kr.or.ddit.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private NoticeDAO noticeDAO;
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public List<NoticeVO> noticeList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {			
			List<NoticeVO> noticeList = noticeDAO.NoticeList(session);
			return noticeList;
		} finally {
			session.close();
		}
	}

}
