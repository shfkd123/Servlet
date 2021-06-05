<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("회원을 삭제했습니다. \n 회원리스트 페이지로 이동합니다.");
	
	<c:if test="${!empty loginUser}"> //로그인 유저가 있다면 => 자기자신 삭제하지 않음 존재하는 유저
		window.opener.parent.location.reload();
		//reload
	</c:if>

	<c:if test="${empty loginUser}"> //로그인 유저 없다면 ==> 자기 자신 삭제
		window.opener.parent.location.href="/";
		//root로 
	</c:if>
	
	CloseWindow();
</script>