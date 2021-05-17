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

@WebServlet("/MemberInfoInsertServlet")
public class MemberInfoInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/member/memberInfoInsert.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		
			String memId = request.getParameter("memId");
			String memName = request.getParameter("memName");
			String memPass = request.getParameter("memPass");
			String memHp = request.getParameter("memHp");
			String memEmail = request.getParameter("memEmail");
			
			
			MemberManagementService service = MemberManagementServiceImpl.getInstance();

			MemberManagementVO mv = new MemberManagementVO();
			
			mv.setMemId(memId);
			mv.setMemName(memName);
			mv.setMemPass(memPass);
			mv.setMemHp(memHp);
			mv.setMemEmail(memEmail);
			
			int cnt = service.memberInfoInsert(mv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			String redirectUrl = request.getContextPath() + 
					"/MemberManagementServlet?msg=" + URLEncoder.encode(msg, "UTF-8"); 
			response.sendRedirect(redirectUrl);
	}

}
