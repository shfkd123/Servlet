package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;
import com.spring.dto.NoticeVO;

public interface BoardService {
	
	// 목록조회	
	Map<String,Object> getBoardList(SearchCriteria cri)throws SQLException;
	
	//파일명으로 찾기
	BoardVO findFileInContent(String fileName)throws SQLException;
	
	// 상세보기
	BoardVO getBoard(int bno)throws SQLException;	
	BoardVO getBoardForModify(int bno)throws SQLException;
		
	// 등록
	void regist(BoardVO board)throws SQLException;
		
	// 수정
	void modify(BoardVO board)throws SQLException;
	
	// 삭제
	void remove(int bno)throws SQLException;
}