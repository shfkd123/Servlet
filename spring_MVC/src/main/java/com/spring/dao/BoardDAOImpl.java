package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO{

	private SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<BoardVO> boardList = session.selectList("Board-Mapper.selectSearchBoardList", cri, rowBounds);
		return boardList;
	}

	@Override
	public int selectSearchBoardListCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		count = session.selectOne("Board-Mapper.selectSearchBoardListCount", cri);
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByBno", bno);
		return board;
	}

	@Override
	public void increaseViewCount(int bno) throws SQLException {
		session.update("Board-Mapper.increaseViewCount", bno);
		
	}

	@Override
	public int selectBoardSequenceNextValue() throws SQLException {
		int seq_num = session.selectOne("Board-Mapper.selectBoardSequenceNextValue");
		return seq_num;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		session.update("Board-Mapper.insertBoard", board);
		
	}
	
	@Override
	public void modifyBoard(BoardVO board) throws SQLException {
		session.update("Board-Mapper.modifyBoard", board);
		
	}
	
	@Override
	public void removeBoard(int bno) throws SQLException {
		session.update("Board-Mapper.removeBoard", bno);
		
	}

}
