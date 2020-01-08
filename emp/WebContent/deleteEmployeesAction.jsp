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
	//불러온값 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	System.out.println(empNo);
	//불러온값이 null이라면 목록페이지로 보냄
	if(request.getParameter("empNo") == null) {
		response.sendRedirect("./selectEmployeesList.jsp");
	}
	
	//Dao의 delete 메서드 호출
	EmployeesDao employeesDao = new EmployeesDao();
	employeesDao.deleteEmployeesAction(empNo);
	
	//작업수행 후 해당페이지로 이동
	response.sendRedirect("./selectEmployeesList.jsp");
	
%>
</body>
</html>