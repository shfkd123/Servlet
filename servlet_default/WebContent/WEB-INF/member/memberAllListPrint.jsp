<%@page import="MemberManagement.dto.MemberManagementVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	List<MemberManagementVO> memList = (List<MemberManagementVO>)request.getAttribute("memList");
	
	String msg = request.getParameter("msg") == null ? "": request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<table border="1">
		<tr>
			<td>ID</td>
			<td>전화번호</td>
			<td>이메일</td>
		</tr>

		<%
		int memSize = memList.size();
	
		if(memSize > 0){
			for(int i = 0; i < memSize; i++){
	%>
		<tr>
			<td><a href="/servlet_default/MemberInfoUpdateServlet?memId=<%=memList.get(i).getMemId() %>"><%=memList.get(i).getMemId() %></a></td>
			<td><%=memList.get(i).getMemHp() %></td>
			<td><%=memList.get(i).getMemEmail() %></td>
		</tr>
		<%				
			}
		}else {	
	%>
		<tr>
			<td colspan="3">회원정보가 없습니다.</td>
		<tr>
			<% 
		}
	%>
		
		<tr align="center">
			<td colspan="3"><a href="member/memberInfoInsert.jsp">[회원 등록]</a></td>
		</tr>
	</table>

	<%
		if(msg.equals("성공")){	//성공메시지가 전달되면...
	%>
		<script>
			alert("정상적으로 처리되었습니다.");
		</script>
	<%		
		}
	%>
</body>
</html>