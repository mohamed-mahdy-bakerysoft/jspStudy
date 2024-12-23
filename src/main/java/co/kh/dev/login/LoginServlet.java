package co.kh.dev.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 세션정보 가져오기(세션객체가 있으면 세션객체리턴, 없으면 null 리턴)
		HttpSession session = request.getSession(false);
		// 2. 세션정보 있으면 아이디와 패스워드를 가져오고, 없으면 로그인창으로 가게한다.
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (session != null) {
				System.out.println("세션 고유아이디 : " + session.getId());
				// 사용자 정보 id, pass 가져오기
				String id = (String) session.getAttribute("id");
				String pass = (String) session.getAttribute("pass");
				// 사용자 정보를 화면에 출력한다.
				out.println("<html>");
				out.println("<head><title>로그인 정보</title><link rel=\"stylesheet\" href=\"/jspStudy/member/write.css\"></head>");
				out.println("<body>");
				out.println("<h4>로그인 정보</h4>");
				out.println("<table border='1' width='300'>");
				out.println("<tr>");
				out.println("<td width='300' align='center'>" + id + " 님 로그인 되었습니다.</td>");
				out.println("</tr>");
				out.println("<td width='300' align='center'>" + id + " 님의 비밀번호는 "+pass+" 입니다.</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td align='center'>");
				out.println("<a href='/jspStudy/memberList.do'>전체회원정보</a>");
				out.println("<a href='/jspStudy/logoutServlet.do'>로그아웃</a>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			} else {
				out.println("<html>");
				out.println("<head><title>로그인</title><link rel=\"stylesheet\" href=\"/jspStudy/member/write.css\"></head>");
				out.println("<body>");
				out.println("<form method='post' action='/jspStudy/loginCheck.do'id=\"div-main\">");
				out.println("<h4>로 그 인</h4>");
				out.println("<table align=center width=500 border=1>");
				out.println("<tr>");
				out.println("<th class=\"col-key\">아이디</th>");
				out.println("<td>&nbsp;<input id=\"input-id\" type='text' name='id' required></td>");
				out.println("</tr>");
				out.println("<tr width= 200>");
				out.println("<th class=\"col-key\">비번</th>");
				out.println("<td >&nbsp;<input id=\"input-pw1\" type=\"password\" name='pass' required></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<div id=\"btns-submit\">");
				out.println("<input id=\"btn-join\" type='button' onclick = \"location.href = '/jspStudy/member/write.html' \" value='회원가입'>");
				out.println("<input id=\"btn-cancel\" type='submit' value='로그인'>");
				out.println("</div>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
