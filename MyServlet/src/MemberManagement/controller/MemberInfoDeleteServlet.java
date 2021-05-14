package MemberManagement.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberManagement.dto.MemberManagementVO;
import MemberManagement.service.MemberManagementService;
import MemberManagement.service.MemberManagementServiceImpl;


@WebServlet("/MemberInfoDeleteServlet")
public class MemberInfoDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberManagementService service = MemberManagementServiceImpl.getInstance();
		
		List<MemberManagementVO> memList = service.memberAllListPrint();
		
		request.setAttribute("memList", memList);
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/WEB-INF/member/memberAllListPrint.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");
		
		MemberManagementService service = MemberManagementServiceImpl.getInstance();

		MemberManagementVO mv = new MemberManagementVO();
		
		mv.setMemId(memId);
		
		int cnt = service.memberInfoDelete(mv);
		
		response.sendRedirect("/servlet_default/MemberManagementServlet");
	}

}
