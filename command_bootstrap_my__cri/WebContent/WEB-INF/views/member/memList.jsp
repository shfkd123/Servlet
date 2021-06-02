<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cri" value="${pageMaker.cri }"/>
<head></head>
<title></title>
<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-2">
						<br>
							<button class="btn btn-primary" type="button" style="float: right;">회원등록</button>
						<br>
					</div>
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="list_go(1)">
		                     <option value="10">정렬개수</option>
		                     <option value="2" ${cri.perPageNum == 2 ? 'selected':'' }>2개씩</option>
		                     <option value="3" ${cri.perPageNum == 3 ? 'selected':'' }>3개씩</option>
		                     <option value="5" ${cri.perPageNum == 5 ? 'selected':'' }>5개씩</option>
                  		</select>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</div>			
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<table class="table table-bordered" border="1">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>휴대전화번호</th>
							<th>등록날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty memList} ">
							<tr>
								<td colspan="5" id="noneMember">회원정보가 없습니다.</td>
							<tr>
						</c:if>
						<c:forEach items="${memList }" var="member">
							<tr>
								<td>${member.id }</td>
								<td><a href="#">${member.name }</a></td>
								<td>${member.email }</td>
								<td>${member.phone }</td>
								 <td>
                           			<fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd"/>   
                        		</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br> <br>
			</div>
			<div class="col-sm-2"></div>
		</div>
			<c:set var="list_url" value="list.do" />
   		<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
	</div>
	<script src="/resources/js/common/common.js"></script>   
</body>