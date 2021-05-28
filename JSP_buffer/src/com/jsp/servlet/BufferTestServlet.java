package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/out")
public class BufferTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		for (int i = 0; i < 100; i++) {
//			out.println("<h3>안녕하세요</h3>");
//		}
//		
//		new Scanner(System.in).nextLine();
		
//		out.println("<script>alert('네이버로 이동합니다.');"+"location.href='https://www.naver.com';"+"</script>");
		//response.sendRedirext("https://www.naver.com");
		
		String url = "/WEB-INF/views/out.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
