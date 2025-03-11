
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scookie")
public class Setcookie extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 만료일이 있는 쿠키 만들기
		// 브라우저 자체에 SQLite(DB)또는 파일로 저장
		Cookie c1 = new Cookie("account1", "admin");
		c1.setMaxAge(60*60); // 초 단위
//		c1.setMaxAge(10); // 초 단위
		response.addCookie(c1); // response에 담아서 브라우저에 전송하면 알아서 저장 함

		Cookie c2 = new Cookie("account2", "user");
		c2.setMaxAge(60*60); // 초 단위
//		c2.setMaxAge(10); // 초 단위
		response.addCookie(c2); // response에 담아서 브라우저에 전송하면 알아서 저장 함
		
		String value = "한 글";
		value = URLEncoder.encode(value, "utf-8");
		
		System.out.println("c1 : "+ c1.getValue());
		System.out.println("c2 : "+ c2.getValue());
//		Cookie c3 = new Cookie("name2", value);
//		response.addCookie(c3);
		
		// 햄버커 쿠키 생성후 가져오기(만들기)
//		set -> get
		
	}

}
