<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="./insertEmployeesAction.jsp">
		<div>사원번호 : <input type="text" name="empNo"></div>
		<div>생일 : <input type="date" name="birthDate"></div>
		<div>이름 : <input type="text" name="firstName"></div>
		<div>성 : <input type="text" name="lastName"></div>
		<div>성별 : 
			<select name="gender">
				<option value='M'>남</option>
				<option value='F'>여</option>
			</select>
		</div>
		<div>고용일 : <input type="date" name="hireDate"></div>
		<div><button type="submit">입력
		</button></div>
	</form>
</body>
</html>