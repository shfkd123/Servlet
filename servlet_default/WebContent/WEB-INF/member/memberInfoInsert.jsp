<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원 등록하기</title>
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
        <li class="active"><a href="/servlet_default/MemberInfoServlet">회원정보등록</a></li>
        <li><a href="/servlet_default/MemberManagementServlet">회원정보조회</a></li>
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
      <h2>SignUp</h2>
	 <div class="container">
		<form action="/servlet_default/MemberInfoServlet" method="post">
	    <div class="form-group">
	      <label for="memId">I	D:</label>
	      <input type="text" class="form-control" id="memId" placeholder="Enter memId" name="memId">
	    </div>
	    <div class="form-group">
	      <label for="memPass">비밀번호:</label>
	      <input type="password" class="form-control" id="memPass" placeholder="Enter memPass" name="memPass">
	    </div>
	    <div class="form-group">
	      <label for="memHp">전화번호:</label>
	      <input type="text" class="form-control" id="memHp" placeholder="Enter memHp" name="memHp">
	    </div>
	    <div class="form-group">
	      <label for="memEmail">이메일:</label>
	      <input type="text" class="form-control" id="memEmail" placeholder="Enter memEmail" name="memEmail">
	    </div>
	
	    <button type="submit" class="btn btn-default">등록</button>
	  </form>
	</div>
    </div>
    
    
  </div>
</div>

<footer class="container-fluid">
  <p>2021-05-11 대덕인재개발원 403 김민지</p>
</footer>
</body>
</html>
