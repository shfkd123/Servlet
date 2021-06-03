package kr.or.ddit.handler.member;

import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberRegistHandler implements Handler {

	private MemberService memnberService;

	public void setMemnberService(MemberService memnberService) {
		this.memnberService = memnberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/regist_success";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String authority = request.getParameter("authority");
		String name = request.getParameter("name");
		
		String phone = "";
		for (String data : request.getParameterValues("phone")) {
			phone += data;
			
		}
		//MemberVO setting
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setPicture(picture);
		member.setAuthority(authority);
		member.setName(name);
		
		try {
			memnberService.regist(member);
		}catch (SQLException e) {
			e.printStackTrace();
			url="member/regist_fail";
		}
		
		return url;
	}

}
