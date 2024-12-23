<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Date date = new Date();
%>
<HTML>
<HEAD>
<TITLE>표현언어의 사용예제</TITLE>
</HEAD>
<BODY>
	<H3>파라미터값 처리</H3>
	<H4>
		오늘은=
		<%=formatter.format(date)%></H4>
	<H4>오늘은= ${ formatter.format(date) }</H4>
	<FORM action="elexam3.jsp" method="post">
		이름 : <input type="text" name="name" value="${param['name']}">
		<input type="submit" value="확인">
	</FORM>
	<P>이름은: ${param.name} 입니다.</P>
	<P>이름은: ${param["name"]} 입니다.</P>
</BODY>
</HTML>