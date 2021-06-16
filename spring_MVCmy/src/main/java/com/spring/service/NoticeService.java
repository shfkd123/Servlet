package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeService {
   
   // 목록 조회
   Map<String,Object> getNoticeList(SearchCriteria cri)throws SQLException;
   
   //상세보기
   NoticeVO getNotice(int nno)throws SQLException;
   
   // 수정화면 상세
   NoticeVO getNoticeForModify(int nno)throws SQLException;
   
   //등록하기 
   void regist(NoticeVO notice) throws SQLException;
   
   //수정하기
   void modify(NoticeVO notice) throws SQLException;
   
   //삭제하기
   void delete(int nno) throws SQLException;
   
}