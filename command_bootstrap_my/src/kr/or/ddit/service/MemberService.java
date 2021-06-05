package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;

public interface MemberService {
	// 로그인
	void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException;
	
	//회원정보조회
	MemberVO getMember(String id) throws SQLException;
	
	//회원리스트
	List<MemberVO> getMemberList() throws SQLException; //전체리스트
	List<MemberVO> getMemberList(Criteria cri) throws SQLException; //오버로딩 기능의 확장  //현재 보고 있는 리스트 
	Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException;//오버로딩 기능의 확장  //검색한 결과 리스트
	
	//회원등록
	public void regist(MemberVO member) throws SQLException;
	
	//회원 수정
	public void modify(MemberVO member) throws SQLException;
	
	//회원 삭제
	public void delete(String id) throws SQLException;
	
	//회원 정지
	public void disabled(String id) throws SQLException;
	
	//회원 활성
	public void enabled(String id) throws SQLException;
	
}
