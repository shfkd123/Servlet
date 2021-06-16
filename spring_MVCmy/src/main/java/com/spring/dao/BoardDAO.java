package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardDAO {

	//자유 게시판 출력
	List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException;
	
	//자유 게시판 출력 개수
	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;

	//viewcnt 증가
	void increaseViewCount(int bno) throws SQLException;
	
	//자유 게시판 상세 조회
	BoardVO selectBoardByBno(int bno) throws SQLException;
	
	//Board_seq.nextval 가져오기
	int selectBoardSequenceNextValue() throws SQLException;

	//자유 게시판 등록
	void insertBoard(BoardVO board) throws SQLException;
	
	//자유 게시판 수정
	void modifyBoard(BoardVO board) throws SQLException;
	
	//자유 게시판 삭제
	void removeBoard(int bno) throws SQLException;
	


}
