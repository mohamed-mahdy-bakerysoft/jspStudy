<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기에 아래에 있는 멤버 변수를 쓸것이다. <%= declation %></h1>
	<h1>여기에 아래에 있는 멤버 함수를 콜 할수 있다. <%= declation %></h1>
	<h1>연산처리</h1>
	<%
		//내장 객체: context, config, request, response, pageContext, session, out, page
		//자바연산처(제어문, 반복문) : 서비스에서 진행된다.
		String message = "연산처리 문 입니다.";	//message : 지역변수(서비스에 있는 지역변수입니다.)
		out.println("내장객체를 이용한 출력 "+ message);
	%>
	<h1>멤버 변수 선언</h1>
	<%!
		//멤버 변수 선언
		String declation = "멤버 변수 선언";
	%>
	<h1>멤버 함수 선언</h1>
	<%!
		//멤버 함수 선언
		public String getDeclation(){
		return declation;
	}
	%>
</body>
</html>