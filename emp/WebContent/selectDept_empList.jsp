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
	//메소드의 매개변수값을 저장할 변수 생성
	int currentPage = 1;
	// currentPage 를 바뀔때마다 받아서 확인
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	final int rowPerPage = 10;

	//클래스 Dept_empDao 의 오브젝트 dept_empDao 생성
	Dept_empDao dept_empDao = new Dept_empDao();
	//메소드 selectDept_empList 불러오기
	ArrayList<Dept_emp> list = dept_empDao.selectDept_empList(currentPage, rowPerPage);
	
	//메소드 selectDept_empTotalRow() 불러오기
	int totalRow = dept_empDao.selectDept_empTotalRow();
	//불러온값 체크
	System.out.println(totalRow);
	//마지막 페이지 설정
	int endPage = 0;
	if(totalRow%rowPerPage == 0){
		endPage = totalRow/rowPerPage;
	} else {
		endPage = totalRow/rowPerPage+1;
	}
%>
	<h1>사원목록</h1>
	<a href="index.jsp">처음으로</a>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>부서번호</th>
			<th>부서배정일</th>
			<th>부서이동일</th>
		</tr>
<%
	//배열 Dept_emp 목록 출력
	for(Dept_emp de : list) {
%>
		<tr>
			<td><a href="./selectDept_empOne.jsp?empNo=<%=de.getEmpNo()%>&deptNo=<%=de.getDeptNo()%>"><%=de.getEmpNo() %></a></td>
			<td><%=de.getDeptNo() %></td>
			<td><%=de.getFromDate() %></td>
			<td><%=de.getToDate() %></td>
		</tr>
<%
	}
%>
	</table>
	<!-- 페이징작업 마무리 이전 다음 버튼 생성 -->
<%
	if(currentPage > 1) {
%>
		<a href="./selectDept_empList.jsp?currentPage=<%=currentPage-1 %>">이전</a>
<%
	}
%>
<%
	if(currentPage < endPage) {
%>
		<a href="./selectDept_empList.jsp?currentPage=<%=currentPage+1 %>">다음</a>
<%
	}
%>
</body>
</html>