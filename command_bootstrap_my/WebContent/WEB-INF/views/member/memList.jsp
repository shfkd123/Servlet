<%@page import="kr.or.ddit.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<MemberVO> memList = (List<MemberVO>)request.getAttribute("memList");
	
	String msg = request.getParameter("msg") == null ? "": request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<%@include file="/WEB-INF/views/include/style.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-6">
						<br>
						<h4>MEMBER MANAGEMENT</h4>
						<br>
					</div>
					<div class="col-sm-6">
						<br>
						<button class="btn btn-primary" type="button" style="float: right;">회원등록</button>
						<br>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<table class="table table-bordered" border="1">
					<thead>
						<tr>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>이메일</th>
							<th>사진</th>
							<th>0퇴사 1재직 2휴직</th>
							<th>입사일</th>
							<th>휴대전화번호</th>
							<th>등록자</th>
							<th>주소</th>
							<th>권한</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty memList} ">
							<tr>
								<td colspan="11" id="noneMember">회원정보가 없습니다.</td>
							<tr>
						</c:if>
						<c:forEach items="${memList }" var="member">
							<tr>
								<td>${member.id }</td>
								<td>${member.pwd }</td>
								<td><a href="#">${member.name }</a></td>
								<td>${member.email }</td>
								<td>${member.picture }</td>
								<td>${member.enabled }</td>
								<td>${member.regdate }</td>
								<td>${member.phone }</td>
								<td>${member.register }</td>
								<td>${member.address }</td>
								<td>${member.authority }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br> <br>
			</div>
		</div>
	</div>
</body>
</html>