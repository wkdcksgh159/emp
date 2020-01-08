<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int currentPage = 1;
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	final int rowPerPage = 3;
	
	DepartmentsDao departmentsDao = new DepartmentsDao();
	ArrayList<Departments> list = departmentsDao.selectDepartmentsList(currentPage, rowPerPage);
	//메소드 selectDepartmentsTotalRow() 의 totalRow 값 가져오기
	int totalRow = departmentsDao.selectDepartmentsTotalRow();
	//가져온값 확인
	System.out.println(totalRow);
	//마지막 페이지를 설정하기 위한 endPage 변수 생성
	int endPage = 0;
	//마지막페이지설정 totalRow 와 rowPerPage 를 나눈 나머지가 0이아니면 여유값 +1 을 줘서 뒷내용이 짤리는걸 방지
	if(totalRow%rowPerPage == 0){
		endPage = totalRow/rowPerPage;
	} else {
		endPage = totalRow/rowPerPage + 1;
	}
	
%>
	<h1>부서목록</h1>
	<a href="./insertDepartmentsForm.jsp">부서추가</a>
	<table border="1">
		<tr>
			<th>dept_name</th>
		</tr>
<%
	for(Departments d : list){
%>
	<tr>
		<td><a href="./selectDepartmentsOne.jsp?deptNo=<%=d.getDeptNo()%>"><%=d.getDeptName() %></a></td>
	</tr>
<%
	}
%>
	</table>
<%
	if(currentPage > 1) {
%>
		<a href="./selectDepartmentList.jsp?currentPage=<%=currentPage-1 %>">이전</a>
<%
	}
%>
<%
	if(currentPage < endPage) {
%>
		<a href="./selectDepartmentList.jsp?currentPage=<%=currentPage+1 %>">다음</a>
<%
	}
%>
</body>
</html>