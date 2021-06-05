package kr.or.ddit.handler.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.utils.GetUploadPath;

public class MemberRemoveHandler implements Handler{

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/remove_success";
		
		String id = request.getParameter("id");
		
		MemberVO member = memberService.getMember(id); //getMember를 통해 
		
		//이미지 삭제
		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
		String fileName = member.getPicture(); // 이미지 정보를 가지고 있어야 한다. 
		File picture = new File(savedPath, fileName);
		
		if(picture.exists()) {
			picture.delete();
		}
		
		//DB삭제
		memberService.delete(id);
		
		//로그인 유저 확인
		//삭제되는 회원이 로그인 회원인 경우 로그아웃 해야한다.
		MemberVO loginUser= (MemberVO) request.getSession().getAttribute("loginUser");
		if(loginUser.getId().equals(member.getId())) {
			request.getSession().invalidate(); //session 갱신
		}
		
		return url;
	}

}
