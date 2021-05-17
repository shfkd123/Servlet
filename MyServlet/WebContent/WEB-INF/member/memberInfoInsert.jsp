<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <!--=======Font Open Sans======-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!--=======Custom Style======-->
    <link rel="stylesheet" href="css/style.css">

  </head>
  <body>
  <div class="form-box">
    <div class="head">Sign Up</div>        
    <form action="/MyServlet/MemberInfoInsertServlet" method="post" id="login-form">
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">I	D</span>
          </label>
          <input type="text" name="memId" class="form-control" />
        </div>
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">Password</span>
          </label> 
          <input type="password" name="memPass" class="form-control" />
        </div>
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">Name</span>
          </label> 
          <input type="text" name="memName" class="form-control" />
        </div>
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">HP</span>
          </label> 
          <input type="text" name="memHp" class="form-control" />
        </div>
        <div class="form-group">
          <label class="label-control">
            <span class="label-text">Email</span>
          </label> 
          <input type="email" name="memEmail" class="form-control" />
        </div>
        <input class="btn btn-primary" type="submit" value="가입하기">
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
