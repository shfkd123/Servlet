package kr.or.ddit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;

//[정지된 회원 시나리오]
//
//로그인은 되지만 알람으로 정지된 회원임을 알림 
//
//등록, 수정, 삭제는 안되지만(안된다고 알람주고 히스토리 백) 조회는 된다. 
//
//정지버튼은 안보이고 활성화 버튼은 보인다. 
//
//===> Filter로 처리

public class DisabledUserCheckFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
//		//제외할 url 확인
//		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
			
		//login check
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		//disabled 상태 확인
		if(!UserStateCheck(loginUser.getEnabled())) {
			chain.doFilter(request, response);
			return;
		}else {
			httpResp.setContentType("text/html;charset=utf-8");
			PrintWriter out = httpResp.getWriter();
			out.println("<script>");
			out.println("alert('정지된 회원으로 조회만 가능합니다.');");
			out.println("window.parent.location.href='/index.do';");
			out.println("</script>");
			out.close();
		}
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//String excludeURLNames= filterConfig.getInitParameter("UserDisabled");
		System.out.println("필터가 준비되었다.");
	}
	
	private boolean UserStateCheck(int reqUserEnabledState) {
		
		if(reqUserEnabledState == 0)
			return true;
		
		return false;
	}
	
}
