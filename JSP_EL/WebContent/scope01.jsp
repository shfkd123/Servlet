<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	pageContext.setAttribute("msg", "너무 졸립다!");
	request.setAttribute("msg", "자고 싶다!");
	session.setAttribute("msg", "그러면 안돼!!");
	application.setAttribute("msg", "역시 난 멋져!!");
	
	
%>  
<%-- <h1>${sessionScope.msg }</h1> --%>  
<h1>${param.msg }</h1>  

 