package com.servlet.dao;

import java.sql.SQLException;

import member.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMemberByID(String memId) throws SQLException;
}
