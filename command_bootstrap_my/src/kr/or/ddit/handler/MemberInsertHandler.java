package kr.or.ddit.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;

public class MemberInsertHandler implements Handler {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/memInsert";

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String enabled = request.getParameter("enabled");
		String regdate = request.getParameter("regdate");
		String phone = request.getParameter("phone");
		String register = request.getParameter("register");
		String address = request.getParameter("address");
		String authority = request.getParameter("authority");

		MemberVO mv = new MemberVO();

		try {
			mv.setId(id);
			mv.setPwd(pwd);
			mv.setName(name);
			mv.setEmail(email);
			mv.setPicture(picture);
			mv.setEnabled(enabled);
			mv.setRegdate(regdate);
			mv.setPhone(phone);
			mv.setRegister(register);
			mv.setAddress(address);
			mv.setAuthority(authority);

			int cnt = memberService.memberInfoInsert(mv);

		} catch (SQLException e) {
			e.printStackTrace();
			url = null;
		}
		
		return url;
	}

}
