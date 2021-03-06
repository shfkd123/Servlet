package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;

import member.vo.MemberVO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberService memberService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view =  "/WEB-INF/views/login.jsp"; //이곳의 경로는 톰캣(was)가 읽는다. 
		
		request.getRequestDispatcher(view).forward(request, response);//Dispatcher야 이 view를 forward해줘! 근데 그대로 넘길래!!
		//Attribute는 내가 받은 request를  그대로 담아서 jsp로 넘기는 것(get, set)
		//HTMLView.loginView(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 url - 잘 됐을 때
		String view = "/WEB-INF/views/login_success.jsp";
		
		//입력
		String id=request.getParameter("memId");
		String pwd=request.getParameter("memPass");
		
		//처리
		String script="";
		//memService.login(id,pwd) : memberVO, InvalidPasswordException, NotFoundIDException, SQLException
		try {
			MemberVO member = memberService.login(id, pwd);
			
			if(!id.equals("shfkd9502"))throw new NotFoundIDException();
			
			/*script="alert('로그인 성공했습니다.');"
					+"location.href='"+request.getContextPath()+"/main';";*/
		} catch (NotFoundIDException e) {
			script="alert('"+e.getMessage()+"');"
					+"history.go(-1);"; //사용자가 확인누르면 입력된 아이디와 비밀번호를 가지고 뒤로간다.
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			script="alert('"+e.getMessage()+"');"
					+"location.href='/login';"; //새로고침으로 입력된 아이디 와 비밀번호는 사라진다.
			e.printStackTrace();
		} catch (SQLException e) {
			script="alert('서버장애로 인해 불가합니다.');"
					+"history.go(-1);";
			e.printStackTrace();
		}
		 
		//출력
		//HTMLView.html(response, script);
		
		request.setAttribute("script", script);
		request.getRequestDispatcher(view).forward(request, response);
		
		
	}

}
