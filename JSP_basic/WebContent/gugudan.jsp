<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

	<%
	for(int dan = 2; dan<10; dan++){
	%>
	
	<h3><%=dan%>단 입니다.</h3>
	
	<%
		for(int gop=1; gop<10; gop++){
	%>
	
	<p><%=dan %> * <%=gop %> = <%=dan*gop %></p>
	 
	 <%
		}
	 %>
	 <br/>
	 <%
	}
%>