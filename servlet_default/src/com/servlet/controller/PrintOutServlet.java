package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/print.html")
public class PrintOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Hello");
		
		Scanner scan = new Scanner(System.in);
		
		String message = request.getParameter("message");
		String color = request.getParameter("color");
		String bg = request.getParameter("bg");
		/*Header setting - setting 먼저하고 세팅된 헤더의 상태로 out을 가져와야 함.*/
//		response.setContentType("application/octttt;charset=utf-8"); //text있는 그대로(plain), 인코딩 방식은 utf-8
		response.setContentType("text/html;charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>연습</title>");
		out.println("<style>");
		out.println("body {background-color:"+ bg + ";" + "color:" + color + ";"+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.printf("<h1>%s</h1>", message); //console에서 요청한 브라우저로 출력되는 곳이 바뀜.
		out.println("</body>");
		out.println("</html>");
	}

}
