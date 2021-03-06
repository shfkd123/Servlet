<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!--=======Font Open Sans======-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!--=======Custom Style======-->
    <link rel="stylesheet" href="css/style.css">

  </head>
  <body>
  <div class="form-box">
    <div class="head">Welcome Back</div>        
    <form action="/MyServlet/MemberLoginServlet" method="post" id="login-form">
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">ID</span>
          </label>
          <input type="text" name="memId" class="form-control" />
        </div>
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">Password</span>
          </label> 
          <input type="password" name="memPass" class="form-control" />
        </div>
        <input type="submit" value="Login" class="btn" />
        <p class="text-p">Don't have an account? <a href="/MyServlet/MemberInfoInsertServlet">Sign up</a> </p>
    </form>
  </div>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script type="text/javascript">
$(window).load(function(){
  $('.form-group input').on('focus blur', function (e) {
      $(this).parents('.form-group').toggleClass('active', (e.type === 'focus' || this.value.length > 0));
  }).trigger('blur');
});
</script>
</body>
</html>
