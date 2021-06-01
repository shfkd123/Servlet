package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public List<NoticeVO> NoticeList(SqlSession session) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.noticeList");
		return noticeList;
	}

}
