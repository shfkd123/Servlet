<%@page import="kr.or.ddit.dto.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	List<NoticeVO> noticeList = (List<NoticeVO>)request.getAttribute("noticeList");

%>
<head></head>

<title>공지사항</title>

<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-6">
						<br>
						<h4>Notice</h4>
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
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>내용</th>
							<th>작성일</th>
							<th>조회수</th>		
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty noticeList} ">
							<tr>
								<td colspan="11" id="noneMember">작성된 글이 없습니다.</td>
							<tr>
						</c:if>
						<c:forEach items="${noticeList }" var="notice">
							<tr>
								<td>${notice.nno }</td>
								<td>${notice.title }</td>
								<td><a href="#">${notice.writer }</a></td>
								<td>${notice.content }</td>
								<td>${notice.regDate }</td>
								<td>${notice.viewcnt }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br> <br>
			</div>
		</div>
	</div>
</body> 