<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//검색기능
	request.setCharacterEncoding("utf-8");
	
	String gender = request.getParameter("gender");
	String[] searchColumn = request.getParameterValues("searchColumn");
	String word = request.getParameter("word");
	System.out.println("gender : "+gender);
	System.out.println("searchColumn : "+searchColumn);
	if(searchColumn != null) {
		for(String sc : searchColumn) {
			System.out.println("sc : "+sc);
		}
	}
	System.out.println("word : "+word);
	
	
	//

	
	//현재페이지설정
	int currentPage = 1;
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	//페이지당 항목 개수제한
	final int rowPerPage = 10;
	
	//클래스 DepartmentsDao 불러오기
	EmployeesDao employeesDao = new EmployeesDao();
	ArrayList<Employees> list = null;
	if(gender == null && searchColumn == null || gender.equals("all")){
		list = employeesDao.selectEmployeesList(currentPage, rowPerPage);
	} else if(searchColumn == null && gender != null && !gender.equals("all")){
		list = employeesDao.selectEmployeesList2(gender, currentPage, rowPerPage);
	} else if(searchColumn.equals("firstName") && gender != null && !gender.equals("all")){
		list = employeesDao.selectEmployeesList3(gender, currentPage, rowPerPage);
	}
	
	//마지막페이지 설정
	int totalRow = employeesDao.selectEmployeesTotalRow();
	System.out.println(totalRow);
	int endPage = 0;
	if(totalRow%rowPerPage==0){
		endPage = totalRow/rowPerPage;
	} else {
		endPage = totalRow/rowPerPage + 1;
		
	}
%>
	<h1>사원정보</h1>
	<form action="./selectEmployeesList.jsp" method="post">
		<div>
			gender : 
			<select name="gender">
				<option value="all">전체</option>
				<option value="M">남자</option>
				<option value="F">여자</option>
			</select>
		</div>
		<div>
			<input type="checkbox" name="searchColumn" value="firstName">first_name
			<input type="checkbox" name="searchColumn" value="lastName">last_name
		</div>
		<div>
			<input type="text" name="word">
			<button type="submit">검색</button>
		</div>
	</form>
	<a href="./insertEmployeesForm.jsp">사원추가</a>
	<table border="1">
		<tr>
			<th>emp_no</th>
			<th>first_name</th>
			<th>상세보기</th>
		</tr>
<%
	for(Employees e : list) {
%>
	<tr>
		<td><%=e.getEmpNo() %></td>
		<td><%=e.getFirstName() %></td>
		<td><a href="./selectEmployeesOne.jsp?empNo=<%=e.getEmpNo() %>">상세보기</a></td>
	</tr>
<%
	}
%>
	</table>
<%
	if(currentPage > 1){
%>
		<a href="./selectEmployeesList.jsp?currentPage=<%=currentPage-1 %>">이전</a>
<%
	}
%>
<%
	if(currentPage < endPage){	
%>
		<a href="./selectEmployeesList.jsp?currentPage=<%=currentPage+1 %>">다음</a>
<%
	}
%>
</body>
</html>