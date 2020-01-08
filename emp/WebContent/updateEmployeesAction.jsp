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
	
	//폼으로 받아온값 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String birthDate = request.getParameter("birthDate");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String gender = request.getParameter("gender");
	String hireDate = request.getParameter("hireDate");
	
	//저장한값 체크
	System.out.println(empNo);
	System.out.println(birthDate);
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(gender);
	System.out.println(hireDate);
	
	//받아온값을 Employees 클래스의 오브젝트 employees를 생성해 저장
	Employees employees = new Employees();
	employees.setEmpNo(empNo);
	employees.setBirthDate(birthDate);
	employees.setFirstName(firstName);
	employees.setLastName(lastName);
	employees.setGender(gender);
	employees.setHireDate(hireDate);
	
	//updateEmployees 메소드를 사용하기 위해 EmployeesDao 클래스의 오브젝트 생성
	EmployeesDao employeesDao = new EmployeesDao();
	employeesDao.updateEmployees(employees);
	
	//작업수행후 해당페이지로 이동
	response.sendRedirect("./selectEmployeesList.jsp");
	
%>
</body>
</html>