<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String deptNo = request.getParameter("deptNo");
	
	DepartmentsDao departmentsDao = new DepartmentsDao();
	Departments departments = departmentsDao.selectDepartmentsOne(deptNo);
%>
	<table border="1">
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<tr>
			<td><%=departments.getDeptNo() %></td>
			<td><%=departments.getDeptName() %></td>
			<td><a href="./updateDepartmentsForm.jsp?deptNo=<%=departments.getDeptNo()%>">수정</a></td>
			<td><a href="./deleteDepartmentsAction.jsp?deptNo=<%=departments.getDeptNo() %>">삭제</a></td>
		</tr>
		
	</table>
</body>
</html>