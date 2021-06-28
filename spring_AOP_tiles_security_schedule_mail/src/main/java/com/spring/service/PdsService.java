package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.AttachVO;
import com.spring.dto.BoardVO;
import com.spring.dto.PdsVO;

public interface PdsService {

	// 리스트조회
	Map<String, Object> getList(SearchCriteria cri) throws SQLException;

	// 본문 이미지파일명으로 찾기
	PdsVO findFileInContent(String fileName) throws SQLException;

	// 글조회
	PdsVO getPds(int pno) throws SQLException;

	// 글작성
	void regist(PdsVO pds) throws SQLException;

	// 글수정
	void modify(PdsVO pds) throws SQLException;

	// 글삭제
	void remove(int pno) throws SQLException;

	// 글읽기(조회수증가)
	PdsVO read(int pno) throws SQLException;

	// 첨부파일 조회
	AttachVO getAttachByAno(int ano) throws SQLException;

	// 파일 정보 삭제
	void removeAttachByAno(int ano) throws SQLException;

}
