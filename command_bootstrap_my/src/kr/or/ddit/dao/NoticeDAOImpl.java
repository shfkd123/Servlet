package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public List<NoticeVO> selectSearchNoticeList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getEndRowNum();
		RowBounds row = new RowBounds(offset, limit);
		
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList", cri, row);

		return noticeList;
	}

	@Override
	public int selectSearchNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count = 0;
		count = session.selectOne("Notice-Mapper.selectSearchNoticeListCount", cri);
		return count;
	}

	@Override
	public int selectNoticeSequenceNextValue(SqlSession session, int nno) throws SQLException {
		int seq_num = session.selectOne("Notice-Mapper.selectNoticeSequenceNextValue", nno);
		return seq_num;
	}

	@Override
	public NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException {
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNno", nno);
		return notice;
	}

}
