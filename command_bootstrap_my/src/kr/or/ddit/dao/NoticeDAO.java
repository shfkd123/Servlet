package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeDAO {
	
	//[리스트] 
	/**
	 * 키워드 검색 조회 결과
	 * @param session
	 * @param cri
	 * @return list
	 * @throws SQLException
	 */
	List<NoticeVO> selectSearchNoticeList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	/**
	 * 키워드 검색 조회 결과 count
	 * @param session
	 * @param cri
	 * @return cnt
	 * @throws SQLException
	 */
	int selectSearchNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	/**
	 * Notice_seq.nextval 가져오기 
	 * @param session
	 * @param nno
	 * @return nno nextVal
	 * @throws SQLException
	 */
	int selectNoticeSequenceNextValue(SqlSession session, int nno) throws SQLException;
	
	/**
	 * 공지번호에 해당하는 공지글 상세조회
	 * @param session
	 * @param nno
	 * @return noticeVO
	 * @throws SQLException
	 */
	NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException;
	
	//등록
	
	//수정
	
	//삭제
	
	//상세 조회

}
