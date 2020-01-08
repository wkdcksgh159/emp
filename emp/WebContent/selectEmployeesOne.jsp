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
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	//1. select 쿼리 실행 후 ResultSet 가져오는 기능
	EmployeesDao employeesDao = new EmployeesDao();
	Employees employees = employeesDao.selectEmployeesOne(empNo);
	
%>
		<table border="1">
			<tr>
				<td>empNo</td>
				<td><%=employees.getEmpNo() %></td>
			</tr>
			<tr>
				<td>birthDate</td>
				<td><%=employees.getBirthDate() %></td>
			</tr>
			<tr>
				<td>firstName</td>
				<td><%=employees.getFirstName() %></td>
			</tr>
			<tr>
				<td>lastName</td>
				<td><%=employees.getLastName() %></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><%=employees.getGender() %></td>
			</tr>
			<tr>
				<td>hireDate</td>
				<td><%=employees.getHireDate() %></td>
			</tr>
			<tr>
				<td><a href="./updateEmployeesForm.jsp?empNo=<%=employees.getEmpNo()%>">수정</a></td>
				<td><a href="./deleteEmployeesAction.jsp?empNo=<%=employees.getEmpNo() %>">삭제</a></td>
			</tr>
		</table>
</body>
</html>