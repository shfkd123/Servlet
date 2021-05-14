package member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Scanner scan = new Scanner(System.in);

		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
		String memHp = request.getParameter("memHp");
		String memMail = request.getParameter("memMail");

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원 로그인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/servlet_default/Login.html\"method=\"post\">");
		out.println("<div id='login_box'>");
		out.println("<h2>Member Login</h2>");
		out.println("<span>ID &nbsp</span>");
		out.println("<input type=\'text\'name=\"memId\"id=\"memId\"><br>");
		out.println("<span>PW</span>");
		out.println("<input type=\'password\'name=\"memPass\"id=\"memPass\"><br>");
		out.println("<input type='submit' value='로그인'>");
		out.println("</div>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");
//		String memHp = request.getParameter("memHp");
//		String memMail = request.getParameter("memMail");

		IMemberService memberService = MemberServiceImpl.getInstance();

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemPass(memPass);
//        mv.setMemHp(memHp);
//        mv.setMemMail(memMail);   

		boolean mv2 = memberService.checkMember(mv);
		
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		
		if (mv2 == true) {
			// mv2가 true이면 아이디가 같은 회원이 존재

			// getMember로 비밀번호와 아이디가 같은지 확인하고 같으면 회원정보 조회
			mv = memberService.getMember(mv);
			if (mv != null) {	
				out.println("<script type='text/javascript'>alert('로그인 성공!');</script>");			
				doGet(request, response);
				return;

			}else {
				out.println("<script type='text/javascript'>alert('로그인 실패!');</script>");
				doGet(request, response);
				return;
			}

		}else {
			out.println("<script type='text/javascript'>alert('등록된 회원이 없습니다.');</script>");
			doGet(request, response);
			return;
		}

	}
}
