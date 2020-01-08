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
	request.setCharacterEncoding("utf-8");
	
	String deptNo = request.getParameter("deptNo");
	System.out.println(deptNo);
	String deptName = request.getParameter("deptName");
	System.out.println(deptName);
	
	Departments departments = new Departments();
	departments.setDeptNo(deptNo);
	departments.setDeptName(deptName);
	
	DepartmentsDao departmentsDao = new DepartmentsDao();
	int resultRowCnt = departmentsDao.insertDepartments(departments);
	
	response.sendRedirect("./selectDepartmentList.jsp");
%>
</body>
</html>