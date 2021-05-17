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


@WebServlet("/MemberInfoServlet")
public class MembergetInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/member/getmemberInfo.jsp";
		
		String memId = request.getParameter("memId");
		
		MemberManagementService service = MemberManagementServiceImpl.getInstance();
		
		MemberManagementVO mv = service.getMemberInfo(memId);
		
		request.setAttribute("mv", mv);
		
		request.getRequestDispatcher(url).forward(request, response);

	}
}
