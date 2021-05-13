<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	for(int i=1; i<11; i++){
	MemberVO member = new MemberVO("mimi"+i, "mimi", "mimi@naver.com", "010-1234-1234");
		memberList.add(member);
	}
	pageContext.setAttribute("memberList", memberList);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
      <%-- <%
         //단순 반복문
         for (int i =0; i < memberList.size(); i++){
            pageContext.setAttribute("member", memberList.get(i));
         }
      %>
      <%
         // 집합체 반복문
         if(memberList!=null) for(MemberVO member : memberList){
            pageContext.setAttribute("member", member);
         }
      %> --%>
      
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>HP</th>
		</tr>
		<%
         // 집합체 반복문
         if(memberList!=null) for(MemberVO member : memberList){
            pageContext.setAttribute("member", member);
         
      %>
		<tr>
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.email }</td>
			<td>${member.phone }</td>
		</tr>
		<%
         }
		%>
	</table>
</body> 
</html> 