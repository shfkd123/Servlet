package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeDAO {

	List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException;

	int selectSearchNoticeListCount(SearchCriteria cri) throws SQLException;

	NoticeVO selectNoticeByNno(int nno) throws SQLException;
	
	NoticeVO selectNoticeByFileName(String fileName) throws SQLException;

	// viewcnt 증가
	void increaseViewCount(int nno) throws SQLException;

	// Notice_seq.nextval 가져오기
	int selectNoticeSequenceNextValue() throws SQLException;

	void insertNotice(NoticeVO Notice) throws SQLException;

	void updateNotice(NoticeVO Notice) throws SQLException;

	void deleteNotice(int nno) throws SQLException;
	
	

}