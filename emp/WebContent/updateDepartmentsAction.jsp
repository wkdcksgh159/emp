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
	//한글
	request.setCharacterEncoding("utf-8");

	String deptNo = request.getParameter("deptNo");
	String deptName = request.getParameter("deptName");
	
	System.out.println("deptNo : "+deptNo);
	System.out.println("deptName : "+deptName);
	
	Departments departments = new Departments();
	departments.getDeptNo();
	departments.getDeptName();
	
	DepartmentsDao departmentsDao = new DepartmentsDao();
	departmentsDao.updateDepartments(departments);
	
	response.sendRedirect("./selectDepartmentList.jsp");
%>
</body>
</html>