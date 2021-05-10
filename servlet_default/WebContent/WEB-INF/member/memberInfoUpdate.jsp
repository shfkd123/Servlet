<%@page import="MemberManagement.dto.MemberManagementVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	MemberManagementVO mv = (MemberManagementVO)request.getAttribute("mv");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<form action="/servlet_default/MemberInfoUpdateServlet" method="post">
		<table border="1">
			<tr>
				<td>I	D:</td>
				<td><input type="text" name="memId" value="<%=mv.getMemId() %>"></td> 
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="text" name="memPass" value="<%=mv.getMemPass()%>"></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" name="memHp" value="<%=mv.getMemHp()%>"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" name="memEmail" value="<%=mv.getMemEmail()%>"></td>
			</tr>
		</table>
		<input type="submit" value="정보수정">
	</form>
</body>
</html>