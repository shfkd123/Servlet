package MemberManagement.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberManagement.dto.MemberManagementVO;
import MemberManagement.service.MemberManagementService;
import MemberManagement.service.MemberManagementServiceImpl;

@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/member/Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
		
		MemberManagementService service = MemberManagementServiceImpl.getInstance();
		
		MemberManagementVO mv = new MemberManagementVO();
		
		mv.setMemId(memId);
		mv.setMemPass(memPass);
		
		boolean mv2 = service.checkMember(mv);

		if(mv2 == true) {
			String redirectUrl = request.getContextPath() + "/MemberManagementServlet";
			response.sendRedirect(redirectUrl);
		}else {
			doGet(request, response);
			return;
		}
	}
}
