package kr.or.ddit.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberDisabledHandler implements Handler{

	private MemberService memberService;
	
	public void setMemberSerivce(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/stop_success";
		
		String id = request.getParameter("id");
		
		memberService.disabled(id);
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(id.equals(loginUser.getId())) {
			session.invalidate(); //세션 초기화 
		}
		
		return url;
	}

}
