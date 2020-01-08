<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertDepartmentsForm</title>
</head>
<body>
	<form method="post" action="./insertDepartmentsAction.jsp">
		<div>부서번호 입력 : <input type="text" name="deptNo"></div>
		<div>부서이름 입력 : <input type="text" name="deptName"></div>
		<div><button type="submit">입력</button></div>
	</form>
</body>
</html>