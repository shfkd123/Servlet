package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.command.LoginCommand;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;

@Controller
public class CommonController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/common/login", method=RequestMethod.GET)
	public void loginForm() throws Exception{}

	@RequestMapping(value="/common/login", method=RequestMethod.POST)
	public ModelleAndView loginPost(ModelAndView mnv, LoginCommand loginReq, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/index.do";
		
		HttpSession session = request.getSession();
		
		try {
			service.login(loginReq.getId(), loginReq.getPwd());
			session.setAttribute("loginUser", service.getMember(loginReq.getId()));
			session.setMaxInactiveInterval(6*60);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (NotFoundIDException | InvalidPasswordException e) {
			url = "redirect:/common/login.do";
			rttr.addFlashAttribute("msg", e.getMessage());
		}
		return url;
	}
	
}
