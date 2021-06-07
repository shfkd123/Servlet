package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeService {
   
   // 목록 조회
   Map<String,Object> getNoticeList(SearchCriteria cri)throws SQLException;
   
   //상세보기
   NoticeVO getNotice(int nno)throws SQLException;
   
   // 수정화면 상세
   NoticeVO getNoticeForModify(int nno)throws SQLException;
   
}