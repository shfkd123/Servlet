package com.spring.security;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.spring.dto.MemberVO;
import com.spring.service.MemberService;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		UserDetails user = (UserDetails)authentication.getPrincipal();
		String username = user.getUsername();
		
		//bean들을 땡김
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/spring/context/root-context.xml");
		
		//땡김으로서 MemberService를 가져올 수 있게 됨.
		MemberService service = ctx.getBean("memberService", MemberService.class);
		
		try {
			MemberVO loginUser = service.getMember(username);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUSer", loginUser);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
