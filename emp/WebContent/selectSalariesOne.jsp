<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmpOne</title>
</head>
<body>
<%
	int empNo = 10001;
	//1. select 쿼리 실행 후 ResultSet 가져오는 기능
	SalariesDao salariesDao = new SalariesDao();
	Salaries salaries = salariesDao.selectSalariesOne(empNo);
	
%>
		<table border="1">
			<tr>
				<td>empNo</td>
				<td><%=salaries.empNo %></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><%=salaries.salary %></td>
			</tr>
			<tr>
				<td>fromDate</td>
				<td><%=salaries.fromDate %></td>
			</tr>
			<tr>
				<td>toDate</td>
				<td><%=salaries.toDate %></td>
			</tr>
		</table>
</body>
</html>