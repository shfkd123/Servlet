package com.servlet.service;

import java.sql.SQLException;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

import member.vo.MemberVO;

public interface MemberService {
	MemberVO login(String memId, String memPass)
		throws NotFoundIDException, InvalidPasswordException, SQLException;
		
}
