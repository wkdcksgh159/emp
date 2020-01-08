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
	int currentPage = 1;
	int rowPerPage = 10;
	//클래스 Dept_managerDao 를 사용하기위한 오브젝트생성
	Dept_managerDao dept_managerDao = new Dept_managerDao();
	//클래스 ArrayList Dept_managerDao 의 메소드 selectDept_managerList 값들을 불러와 클래스 Dept_manager의 오브젝트 dept_manager에 저장
	ArrayList<Dept_manager> dept_manager = dept_managerDao.selectDept_managerList(currentPage, rowPerPage);
%>

</body>
</html>