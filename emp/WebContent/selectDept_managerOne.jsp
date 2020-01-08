<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String deptNo = "d001";
	
	Dept_managerDao dept_managerDao = new Dept_managerDao();
	Dept_manager dept_manager = dept_managerDao.selectDept_managerOne(deptNo);
%>
	<table border="1">
		<tr>
			<td>empNo</td>
			<td><%=dept_manager.getEmpNo() %></td>
		</tr>
		<tr>
			<td>deptNo</td>
			<td><%=dept_manager.getDeptNo() %></td>
		</tr>
		<tr>
			<td>fromDate</td>
			<td><%=dept_manager.getFromDate() %></td>
		</tr>
		<tr>
			<td>toDate</td>
			<td><%=dept_manager.getToDate() %></td>
		</tr>
	</table>
</body>
</html>