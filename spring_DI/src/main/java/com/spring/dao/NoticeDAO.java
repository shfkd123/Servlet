package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeDAO {

   List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException;

   int selectSearchNoticeListCount(SearchCriteria cri) throws SQLException;
   
   NoticeVO selectNoticeByNno (int nno) throws SQLException;
   
   //viewcnt 증가
   void increaseViewCount(int nno) throws SQLException;
   
   // Notice_seq.nextval 가져오기
   int selectNoticeSequenceNextValue() throws SQLException;
   
   //공지사항 등록
   void insertNotice(NoticeVO notice) throws SQLException;
   
   //공지사항 수정
   void modifyNotice(NoticeVO notice) throws SQLException;
   
   //공지사항 삭제
   void deleteNotice(int nno) throws SQLException;
}