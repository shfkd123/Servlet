package com.spring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.command.LoginCommand;
import com.spring.dto.MenuVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;
import com.spring.service.MenuService;

//컨트롤러야! 빈등록 해줘!!
@Controller
public class CommonController {
	
	//알아서 묶어라 ! MemberService가 Spring Context에 등록되어 있는지 확인한다. 
	//찾았는데 없으면 null이 뜬다. 
	//@Autowired없애고  setMethod적어도 주입되지 않는다. 
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MenuService menuService;
	
	
	//Mapper가 챙김 
	//url과 method 필요
	//value  url // method get/post
	//requestMapping은 클래스에다가도 붙일 수 있다. 
	//클래스 위에 @RequestMapping("/common")으로 주면 밑에서 무엇을 줘도 /common으로 시작한다.
	@RequestMapping(value="/common/login", method=RequestMethod.GET)
	public void loginForm()throws Exception{
		
	} //로그인.do의 get방식일때 쓰는 구나! 라고 HandlerMapper가 알아들음
	
	//핸들러 매퍼를 통해 오는 애들은 .do를 생략한다. login.do로 요청해둬 .do를 매핑하지 않는다.
	//매퍼릉 통해 갈 때 파라미터에 .do~~로 주면 날라간다. 생략되기 때문에 
	//url로는 파일명을 줄 수 없게 된다. 
	//==> pathValue
	
	//return에는 항상 view 이름을 넘겨준다.
	//들어오는 url과 return해주는 url이 동일할 경우 생략이 가능하다.
	//Handler adapter는 요청받은 url을 view Resolver에게 바로 던진다.
	
	@RequestMapping(value="/common/login", method=RequestMethod.POST)
	public String loginPost(LoginCommand loginReq, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String url="redirect:/index.do";
		
		HttpSession session = request.getSession();
		
		try {
			memberService.login(loginReq.getId(), loginReq.getPwd());
			session.setAttribute("loginUser", memberService.getMember(loginReq.getId()));
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
	
	@RequestMapping("/index")
	public ModelAndView indexPage(ModelAndView mnv,
								  @RequestParam(defaultValue="M000000")String mCode, 
								  HttpServletRequest request, HttpServletResponse response) 
										  										throws Exception{
		String url = "common/indexPage";
		
		try {
			List<MenuVO> menuList = menuService.getMainMenuList();			
			MenuVO menu = menuService.getMenuByMcode(mCode);
			
			mnv.addObject("menuList",menuList);
			mnv.addObject("menu",menu);
		} catch (SQLException e) {			
			e.printStackTrace();
			throw e;
		}
		
		mnv.setViewName(url);
		return mnv;
	}
	
}
