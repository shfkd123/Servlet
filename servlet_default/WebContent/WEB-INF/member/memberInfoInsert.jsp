<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
<form action="/servlet_default/MemberInfoServlet" method="post">
		<table border="1">
			<tr>
				<td>I	D:</td>
				<td><input type="text" name="memId" value=""></td> 
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="text" name="memPass" value=""></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" name="memHp" value=""></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><textarea rows="5" cols="10" name="memEmail"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="회원 등록">
	</form>
</body>
</html>