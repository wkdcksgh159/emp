<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
	// 1. 요청 해석
	String deptNo = request.getParameter("deptNo");
	System.out.println(deptNo);
	if(request.getParameter("deptNo") == null){
		response.sendRedirect("./selectDepartmentList.jsp");
	}
	
	// 2. select코드 구현 -> Dao 위임 -> Dao.delete메서드 호출
	DepartmentsDao departmentsDao = new DepartmentsDao();
	departmentsDao.deleteDepartmentsAction(deptNo);
	
	
	// 3.
	response.sendRedirect("./selectDepartmentList.jsp");
%>
