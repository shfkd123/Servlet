<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("회원을 삭제했습니다.\n 회원리스트 페이지로 이동합니다.");
	
	<c:if test="${!empty loginUser}">
		window.opener.parent.location.reload();
	</c:if>
	<c:if test="${empty loginUser}">
		window.opener.parent.location.href="/";
	</c:if>
	
	CloseWindow();
</script>

