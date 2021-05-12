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
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 683px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>MEMBER MANAGEMENT</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="memberMain.jsp">HOME</a></li>
        <li><a href="/servlet_default/MemberInfoServlet">회원정보등록</a></li>
        <li class="active"><a href="/servlet_default/MemberManagementServlet">회원정보조회</a></li>
      </ul><br>
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search Blog..">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>

    <div class="col-sm-9">
      <h4><small>MEMBER MANAGEMENT</small></h4>
      <hr>
      <h2>MemberList</h2>
      <table class="table table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>HP</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
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
    </tbody>
  </table>
      <br><br> 
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>2021-05-11 대덕인재개발원 403 김민지</p>
</footer>
</body>
</html>
