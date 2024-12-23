package co.kh.dev.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.common.DBUtility;

@WebServlet("/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("/jspStudy/loginServlet.do");
		}
		// 1. 사용자 데이터 가져오기

		// 2. 테이블 curd
		Connection con = null;
		String MEMBER_INSERT = "select * from LOGIN order by id desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(MEMBER_INSERT);
			rs = pstmt.executeQuery();

			// 3. 출력하기
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head><title>회원 리스트</title><link rel=\"stylesheet\" href=\"/jspStudy/member/write.css\"></head>");
			out.println("<body>");
			out.println("<h4>전체 회원정보</h4>");
			out.println("<table align=center width=500 border=1>");
			while (rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				out.println("<tr width= 200>");
				out.println("<th class=\"col-key\">아이디</th>");
				out.println("<td align=center>" + id + "</td>");
				out.println("<th class=\"col-key\">비밀번호</th>");
				out.println("<td align=center>" + pass + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<p>");
			out.println("<p align=center><a href=/jspStudy/loginServlet.do>로그인 정보</a></p>");
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
	}
}
