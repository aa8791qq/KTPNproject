

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존 새션 불러오기
		HttpSession sestest = request.getSession(false);
//		HttpSession sestest = request.getSession();
		boolean isNewSession = (sestest == null);
		
//		// 세션 확인 후 없으면 생성
//		if (sestest == null) {
//		    sestest = request.getSession();
//		}
		
		// id 저장(임의값)
//		String id = "admin";
		
		// 세션확인 후 없으면 생성
		if (isNewSession) {
            sestest = request.getSession();
            sestest.setAttribute("username", "admin"); // 새로운 세션에 username 저장
        }
		
//		if (!isNewSession && sestest.getAttribute("username") == null) {
		if (sestest != null && sestest.getAttribute("username") == null) {
            sestest.setAttribute("username", "admin");
        }
		
//		// null값 여부 확인
//		if (sestest.getAttribute("username") == null) {
//		    sestest.setAttribute("username", id);
//		}
//		
//		// 키값 저장
//		sestest.setAttribute("username", id);
		
		// 키값 유효시간
//		if (sestest != null) {
	    sestest.setMaxInactiveInterval(60 * 3);
//	}
		
		// 세션 만료 여부 확인작업
		boolean TF = (sestest == null || sestest.getAttribute("username") == null);
//		boolean TF = (isNewSession || sestest.getAttribute("username") == null);
//		boolean TF = (sestest.getAttribute("username") == null);
		System.out.println(TF);
		
		// 세션 유지 시간 및 남은 시간 계산
        int sessionTimeout = (sestest != null) ? sestest.getMaxInactiveInterval() : 0;
        long lastAccessTime = (sestest != null) ? sestest.getLastAccessedTime() : 0;
        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - lastAccessTime) / 1000;
        int remainingTime = (int) (sessionTimeout - elapsedTime);
        if (remainingTime < 0) remainingTime = 0;
		
		// 응답 출력
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<html><head>");
		
		// 팝업 띄우기
//		response.getWriter().println("<script>");
		// 챗gpt..
//		response.getWriter().println("var remainingTime = " + remainingTime + ";");
//		response.getWriter().println("function updateTimer() {");
//		response.getWriter().println("    if (remainingTime > 0) {");
//		response.getWriter().println("        document.getElementById('timer').innerText = remainingTime + ' 초';");
//		response.getWriter().println("        remainingTime--; setTimeout(updateTimer, 1000);");
//		response.getWriter().println("    } else { document.getElementById('timer').innerText = '세션 만료됨'; }");
//		response.getWriter().println("}");
//		response.getWriter().println("window.onload = updateTimer;");

		response.getWriter().println("<script>");
		// 챗gpt..
		response.getWriter().println("var remainingTime = " + remainingTime + ";");
		response.getWriter().println("function updateTimer() {");
		response.getWriter().println("    if (remainingTime > 0) {");
		response.getWriter().println("        document.getElementById('timer').innerText = remainingTime + ' 초';");
		response.getWriter().println("        remainingTime--;");
		response.getWriter().println("    } else {");
		response.getWriter().println("        document.getElementById('timer').innerText = '세션이 만료되었습니다. 로그인페이지로 돌아갑니다.';");
		response.getWriter().println("        alert('세션이 만료되었습니다. 다시 로그인해주세요.');"); // 팝업 추가
//		response.getWriter().println("        window.location.href = 'login.html';"); // 로그인 페이지 이동
		response.getWriter().println("        clearInterval(timerInterval);"); // 반복 중지
		response.getWriter().println("    }");
		response.getWriter().println("}");
		response.getWriter().println("var timerInterval = setInterval(updateTimer, 1000);"); // 1초마다 실행
		// 챗gpt..

		if(TF == true) {
			response.getWriter().println("alert('세션만료됨. 다시로그인해주세요');");
		}
		response.getWriter().println("</script>");
		response.getWriter().println("</head><body>");
		
		// 지정값 가져오기
		String username = "없음";
        if (sestest != null && sestest.getAttribute("username") != null) {
            username = (String) sestest.getAttribute("username");
        }
        
        // 세션id출력
//        if (sestest != null) {
            response.getWriter().println("<p>세션 ID: " + sestest.getId() + "</p>");
            System.out.println("저장된 세션: " + sestest.getId());
//        } else {
//            response.getWriter().println("<p>세션 ID: 없음</p>");
//            System.out.println("저장된 세션: 없음");
//        }
		
		// 표시하기
//		String username = (String) (sestest != null) ? (String) sestest.getAttribute("username") : "없음");
//		String username = (sestest != null) ? (String) sestest.getAttribute("username") : "없음";
		
//		response.getWriter().println("<p> 저장된 세션: " + (id != null ? id : "없음") + "</p>");
//		response.getWriter().println("<p> 저장된 세션: " + (sestest != null ? sestest.getId() : "없음") + "</p>");
//		response.getWriter().println("<p> Session 유효"+ sestest.getId() + "</p>");
		response.getWriter().println("<p> 저장된 username : " + username + "</p>");
		response.getWriter().println("<p> 세션만료 여부 : "+ TF + "</p>");
        response.getWriter().println("<p>세션 유지 시간(초) : " + sessionTimeout + "</p>");
        response.getWriter().println("<p>세션 남은 시간 : <span id='timer'></span></p>");
//		response.getWriter().println("<p> Session id"+ sestest.getAttribute("username") + "</p>");
		response.getWriter().println("</body></html>");
		
		// 콘솔출력
//		System.out.println("저장된 세션: " + (sestest != null ? sestest.getId() : "없음"));
		System.out.println("세션 저장된 값" + username);
		System.out.println("세션 만료여부" + TF);
		System.out.println("세션 유지 시간: " + sessionTimeout + "초");
		
        System.out.println("남은 시간: " + remainingTime + "초");
//		System.out.println("세션유효함: " + (sestest != null ? sestest.getId() : "없음"));
//		System.out.println("세션유효함: " + (sestest != null ? sestest.getAttribute("username") : "없음"));
	}

}
