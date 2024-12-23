<%@ page contentType="text/html; charset=UTF-8"%>

<!-- 1. 클라이언트가 보내준 사용자정보(request)를 가져온다. 그 이외에 정보를 가져오는 것(세션, application, request)을 가져온다-->
<%
request.setCharacterEncoding("UTF-8");
%>
<!-- 2.curd  -->
<jsp:useBean id="sdao" class="co.kh.dev.memberone.model.StudentDAO" />
<jsp:useBean id="svo" class="co.kh.dev.memberone.model.StudentVO">
	<jsp:setProperty name="svo" property="*" />
</jsp:useBean>
<%
String loginID = (String) session.getAttribute("loginID");
svo.setId(loginID);
boolean flag = sdao.updateDB(svo);
%>

<!-- 3.화면설계(자바코드에 해야되는데 - > jsp service함수에서 진행한다. -->
<html>
<head>
<title>Update Process</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<meta http-equiv="Refresh" content="3;url=login.jsp">
<body>
	<main>
		<%
		if (flag == true) {
			session.setAttribute("pass", svo.getPass());
		%>
		<p>
			입력하신 내용대로 <b>회원정보가 수정 되었습니다.</b><br></br> 3초후에 Logon Page로 이동합니다
		</p>
		<%
		} else {
		%>
		<p>
			입력하신 내용대로 <b>회원정보가 수정 되지 않았습니다.</b><br></br> 3초후에 Logon Page로 이동합니다
		</p>
		<%
		}
		%>
	</main>
</body>
</html>