package co.kh.dev.mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.mvc.control.ActionForward;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("사용자정보를 받고 -> 데이터베이스 조회 -> 결과를 rqeust에 입력 -> 화면.jsp redirect or forward인지 정하는 IndexAction");
		return new ActionForward("index.jsp", false);
	}

}
