<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	
	header {
		height: 150px;
		background: green;
	}
	
	div #content-wrap {
		height: 600px;
		position: relative;
	}
	
	aside {
		width: 300px;
		height: 100%;
		background: blue;
	}
	
	section {
		position: absolute;
		left: 300px;
		top: 0;
		width: 100%;
		height: 100%;
		background: red;
	}
	
	footer {
		height: 150px;
		background: purple;
	}
</style>
</head>
<body>
	<header></header>
	<div id="content-wrap">
		<aside></aside>
		<section></section>
	</div>
	<footer></footer>
</body>
</html>