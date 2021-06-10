package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ReplyVO;

public class ReplyDAOImpl implements ReplyDAO{

	@Override
	public void insertReply(SqlSession session, ReplyVO reply) throws SQLException {
		session.update("Reply-Mapper.insertReply", reply);
	}

	@Override
	public void updateReply(SqlSession session, ReplyVO reply) throws SQLException {
		session.update("Reply-Mapper.updateReply", reply);
		
	}

	@Override
	public void deleteReply(SqlSession session, int rno) throws SQLException {
		session.update("Reply-Mapper.deleteReply", rno);
		
	}

	@Override
	public List<ReplyVO> selectReplyListPage(SqlSession session, int bno, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<ReplyVO> replyList = 
				session.selectList("Reply-Mapper.selectReplyList", bno, rowBounds);
		return replyList;
	}

	@Override
	public int selectReplySeqNextValue(SqlSession session) throws SQLException {
		int rno = (Integer)session.selectOne("Reply-Mapper.selectReplySeqNextValue");
		return rno;
	}

	/**
	 * 자유게시판 리스트에서 댓글 수를 보일 때 사용
	 */
	@Override
	public int countReply(SqlSession session, int bno) throws SQLException {
		int count = session.selectOne("Reply-Mapper.countReply", bno);
		return count;
	}

}
