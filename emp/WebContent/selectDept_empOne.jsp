<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String deptNo = request.getParameter("deptNo");

	Dept_empDao dept_empDao = new Dept_empDao();
	Dept_emp dept_emp = dept_empDao.selectDept_empOne(deptNo, empNo);
	System.out.println(deptNo);
	System.out.println(empNo);
%>
	<table border="1">
		<tr>
			<td>empNo</td>
			<td><%=dept_emp.getEmpNo() %></td>
		</tr>
		<tr>
			<td>deptNo</td>
			<td><%=dept_emp.getDeptNo() %></td>
		</tr>
		<tr>
			<td>fromDate</td>
			<td><%=dept_emp.getFromDate() %></td>
		</tr>
		<tr>
			<td>toDate</td>
			<td><%=dept_emp.getToDate() %></td>
		</tr>
	</table>
</body>
</html>