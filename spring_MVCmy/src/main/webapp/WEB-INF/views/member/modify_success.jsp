<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<body>
<script>
	alert("회원정보 수정에 성공했습니다.\n 회원리스트 페이지로 이동합니다.");

	location.href='detail.do?id=${member.id}';
</script>
</body>