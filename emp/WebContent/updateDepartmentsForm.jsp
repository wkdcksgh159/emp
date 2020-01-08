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
	String deptNo = request.getParameter("deptNo");
	DepartmentsDao departmentsDao = new DepartmentsDao();
	Departments departments = departmentsDao.selectDepartmentsOne(deptNo);
	
%>
	<form action="./updateDepartmentsAction.jsp" method="post">
		<div>
			dept_no : 
			<input type="text" name="deptNo" value="<%=departments.getDeptNo() %>" readonly="readonly">
		</div>
		<div>
			dept_name : 
			<input type="text" name="deptName" value="<%=departments.getDeptName() %>">
		</div>
		<div>
			<button type="submit">부서 수정</button>
		</div>
	</form>
</body>
</html>