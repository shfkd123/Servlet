package com.servlet.dao;

import java.sql.SQLException;

import member.util.SqlMapClientUtil;
import member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	private static MemberDAO memDAO;
	
	private MemberDAOImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static MemberDAO getInstance() {
		if(memDAO == null) {
			memDAO = new MemberDAOImpl();
		}
		return memDAO;
	}
	
	@Override
	public MemberVO selectMemberByID(String memId) throws SQLException {
		return null;
	}

}
