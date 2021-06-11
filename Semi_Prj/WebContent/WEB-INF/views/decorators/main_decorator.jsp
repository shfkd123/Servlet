<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title default="Kim's System"/></title>
<%@ include file="/WEB-INF/views/include/style.jsp" %>

<decorator:head />
</head>
<body  class="hold-transition sidebar-mini" onload="init();">
<div class="wrapper">

<decorator:body />

</div>
<%@ include file="/WEB-INF/views/include/js.jsp" %>	
</body>
</html>




