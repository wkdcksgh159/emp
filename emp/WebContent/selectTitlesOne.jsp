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
	int empNo = 474918;
	//1. select 쿼리 실행 후 ResultSet 가져오는 기능
	TitlesDao titlesDao = new TitlesDao();
	Titles titles = titlesDao.selectTitlesOne(empNo);
	
%>
		<table border="1">
			<tr>
				<td>empNo</td>
				<td><%=titles.getEmpNo() %></td>
			</tr>
			<tr>
				<td>title</td>
				<td><%=titles.getTitle() %></td>
			</tr>
			<tr>
				<td>fromDate</td>
				<td><%=titles.getFromDate() %></td>
			</tr>
			<tr>
				<td>toDate</td>
				<td><%=titles.getToDate() %></td>
			</tr>
		</table>
</body>
</html>