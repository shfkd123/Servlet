package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.Criteria;
import com.spring.command.SearchCriteria;
import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	// 회원정보 조회
	MemberVO selectMemberById(String id) throws SQLException;
	
	//회원리스트 조회
	List<MemberVO> selectMemberList()throws SQLException;
	List<MemberVO> selectMemberList(Criteria cri)throws SQLException;
	List<MemberVO> selectMemberList(SearchCriteria cri)throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	int selectMemberListCount(SearchCriteria cri) throws SQLException;
	
	// 회원 추가
	public void insertMember(MemberVO member) throws SQLException;
	
	//회원 정보 수정
	public void updateMember(MemberVO member) throws SQLException;
	
	//회원 삭제
	public void deleteMember(String id) throws SQLException;
	
	//회원정지
	public void disabledMember(String id) throws SQLException;

	//회원 활성화
	public void enabledMember(String id) throws SQLException;
	
	
}








