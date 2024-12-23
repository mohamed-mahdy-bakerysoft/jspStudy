<%@page import="co.kh.dev.boardone.model.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!-- 1. 클라이언트가 보내준 사용자정보(request)를 가져온다. 그 이외에 정보를 가져오는 것(세션, application, request)을 가져온다-->
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="vo" scope="page"
	class="co.kh.dev.boardone.model.BoardVO">
	<jsp:setProperty name="vo" property="*" />
</jsp:useBean>
<!-- 2.curd  -->
<%
vo.setRegdate(new Timestamp(System.currentTimeMillis()));
vo.setIp(request.getRemoteAddr());
BoardDAO bdao = BoardDAO.getInstance();
boolean flag = bdao.insertDB(vo);
if (flag == true) {
	response.sendRedirect("list.jsp");
} else {
%>
<script>
	alert("게시판글 등록이 실패 되었습니다.");
	history.go(-1);
</script>
<%
}
%>
