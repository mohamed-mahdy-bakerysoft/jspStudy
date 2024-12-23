<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 1.사용자정보를 가져온다. 세션정보를 가져온다 -->
<%
session.invalidate();
%>
<!-- 3.화면설계(자바코드에 해야되는데 - > jsp service함수에서 진행한다. -->
<html>
<head>
<title>Logout</title>
</head>
<body>
	<%
	response.sendRedirect("login.jsp");
	%>
	</font>
</body>
</html>