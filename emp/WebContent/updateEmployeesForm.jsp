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
	//요청 확인
	int empNo = Integer.parseInt(request.getParameter("empNo"));
	
	//메소드를 사용하기 위한 클래스 오브젝트 생성
	EmployeesDao employeesDao = new EmployeesDao();
	Employees employees = employeesDao.selectEmployeesOne(empNo);
%>
	<form action="./updateEmployeesAction.jsp" method="post" >
		<div>
			emp_no : 
			<input type="text" name="empNo" value="<%=employees.getEmpNo()%>" readonly="readonly">
		</div>
		<div>
			birth_date : 
			<input type="date" name="birthDate" value="<%=employees.getBirthDate() %>">
		</div>
		<div>
			first_name : 
			<input type="text" name="firstName" value="<%=employees.getFirstName() %>">
		</div>
		<div>
			last_name : 
			<input type="text" name="lastName" value="<%=employees.getLastName() %>">
		</div>
		<div>
			gender : 
			<select name="gender" value="<%=employees.getGender()%>">
				<option value='M'>남</option>
				<option value='F'>여</option>
			</select>
		</div>
		<div>
			hire_date : 
			<input type="date" name="hireDate" value="<%=employees.getHireDate()%>">
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>