package kr.or.ddit.handler;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;

public class MemberListHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/memList";
		
		List<MemberVO> memList;
		try {
		memList = memberService.memberAllListPrint();
		
		request.setAttribute("memList", memList);
		}catch (SQLException e) {
			e.printStackTrace();
			url = null;
		}
		
		return url;
	}

}
