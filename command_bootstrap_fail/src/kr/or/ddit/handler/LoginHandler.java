package kr.or.ddit.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.service.MemberService;

public class LoginHandler implements Handler {

   private MemberService memberService;
   public void setMemberService(MemberService memberService) {
      this.memberService = memberService;
   }
   
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      String url = "redirect:index.do";
      
      //로그인처리
      String id= request.getParameter("id");
      String pwd= request.getParameter("pwd");
      
      HttpSession session = request.getSession();
      
      try {
         memberService.login(id, pwd);
         session.setAttribute("loginUser",memberService.getMember(id));
         session.setMaxInactiveInterval(6*60); //6분
      } catch(SQLException e) {
         e.printStackTrace();
         throw e;
      } catch (NotFoundIDException | InvalidPasswordException e) {
         url = "redirect:";//<-- redirect할 경우 아이디가 틀리면 다 사라짐 //forward도 마찬가지. 그래서 일반적으로 history back을 함 
      }
      return url;
   }

}