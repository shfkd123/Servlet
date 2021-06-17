package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public interface BoardDAO {

	//자유 게시판 출력
	List<BoardVO> selectSearchBoardList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	//자유 게시판 출력 개수
	int selectSearchBoardListCount(SqlSession session, SearchCriteria cri) throws SQLException;

	//viewcnt 증가
	void increaseViewCount(SqlSession session, int bno) throws SQLException;
	
	//자유 게시판 상세 조회
	BoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException;
	
	//Board_seq.nextval 가져오기
	int selectBoardSequenceNextValue(SqlSession session) throws SQLException;

	//자유 게시판 등록
	void insertBoard(SqlSession session, BoardVO board) throws SQLException;
	
	//자유 게시판 수정
	void modifyBoard(SqlSession session, BoardVO board) throws SQLException;
	
	//자유 게시판 삭제
	void removeBoard(SqlSession session, int bno) throws SQLException;
	


}
