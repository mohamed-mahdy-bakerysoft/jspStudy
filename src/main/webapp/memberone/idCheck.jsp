<%@page import="co.kh.dev.memberone.model.StudentVO"%>
<%@page import="co.kh.dev.memberone.model.StudentDAO"%>
<%@page contentType="text/html; charset=UTF-8"%>

<!-- 1.사용자정보를 가져온다  -->
<!-- 2.curd  -->
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");

StudentVO svo = new StudentVO();
svo.setId(id);
StudentDAO sdao = new StudentDAO();
boolean flag = sdao.selectIdCheck(svo);
%>

<!-- 3.화면설계(자바코드에 해야되는데 - > jsp service함수에서 진행한다. -->
<html>
<head>
<title>ID중복체크</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">
	<br>
	<main>
		<%
		if (flag == true) {
			out.println(id + "는 이미 존재한는 ID입니다.<br></br>");
		} else {
			out.println(id + "는 사용 가능 합니다.<br></br>");
		}
		%>
		<hr>
		<button onClick="javascript:self.close()">닫기</button>
	</main>
</body>
</html>