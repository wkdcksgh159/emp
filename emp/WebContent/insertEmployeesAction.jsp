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

	//폼에서 받아온값 변수에 저장
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	String birthDate = request.getParameter("birthDate");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String gender = request.getParameter("gender");
	String hireDate = request.getParameter("hireDate");
	//오류확인을 위한 저장한 값 체크
	System.out.println(empNo);
	System.out.println(birthDate);
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(gender);
	System.out.println(hireDate);
	
	//저장한값을 클래스 Employees 의 오브젝트 employees 로 이동
	Employees employees = new Employees();
	employees.setEmpNo(empNo);
	employees.setBirthDate(birthDate);
	employees.setFirstName(firstName);
	employees.setLastName(lastName);
	employees.setGender(gender);
	employees.setHireDate(hireDate);
	
	//클래스 EmployeesDao 의 오브젝트 employeesDao 생성
	EmployeesDao employeesDao = new EmployeesDao();
	int resultRowCnt = employeesDao.insertEmployees(employees);
	
	//작업수행 후 해당페이지로 이동
	response.sendRedirect("./selectEmployeesList.jsp");
	
%>
</body>
</html>