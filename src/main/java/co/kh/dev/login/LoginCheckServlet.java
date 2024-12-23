package co.kh.dev.login;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

@WebServlet("/loginCheck.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		String LOGIN_LIST = "select * from LOGIN order by id desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.사용자 정보를 읽는다.
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(LOGIN_LIST);
			rs = pstmt.executeQuery();

			// 2. DB에서 확인한다. id, pass

			// 3. 체크확인 로그인이 인정되면 세션을 만들어서 저장한다.
			while (rs.next()) {
				String idCheck = rs.getString("id");
				String passCheck = rs.getString("pass");
				if (id.equals(idCheck) && pass.equals(passCheck)) {
					// 세션이 있으면 가져오고 없으면 생성한다.
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("pass", pass);
					break;
				}
			}
			response.sendRedirect("/jspStudy/loginServlet.do");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			DBUtility.dbClose(con, pstmt, rs);
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
