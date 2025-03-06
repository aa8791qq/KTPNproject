

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

//import org.json.simple.JSONObject;

@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존 새션 불러오기
//		HttpSession sestest = request.getSession(false);
//		HttpSession sestest = request.getSession();
		HttpSession sestest = request.getSession(true);
		boolean isNewSession = (sestest == null);
		
//		// 세션 확인 후 없으면 생성
//		if (sestest == null) {
//		    sestest = request.getSession();
//		}
		
		// id 저장(임의값)
		String id = "admin";
		
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
        if (remainingTime < 0) {
        	remainingTime = 0;
        }

        // json 응답상태 확인
        
//      JSONObject jsonResponse = new JSONObject();
        Map<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("remainingTime", remainingTime);
        jsonResponse.put("sessionTimeout", sessionTimeout);
        jsonResponse.put("sessionId", sestest.getId());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonOutput = gson.toJson(jsonResponse);
//        response.getWriter().write(jsonResponse.toString());
        System.out.println("JSON 응답: " + jsonOutput);
        response.getWriter().write(gson.toJson(jsonResponse));
        // 콘솔출력
//		System.out.println("저장된 세션: " + (sestest != null ? sestest.getId() : "없음"));
        System.out.println("세션 저장된 값 " + id);
        System.out.println("세션 만료여부 " + TF);
        System.out.println("세션 유지 시간 : " + sessionTimeout + "초");
        
        System.out.println("남은 시간 : " + remainingTime + "초");
//		System.out.println("세션유효함: " + (sestest != null ? sestest.getId() : "없음"));
//		System.out.println("세션유효함: " + (sestest != null ? sestest.getAttribute("username") : "없음"));
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // 🔥 세션 만료
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"message\": \"세션이 만료되었습니다.\"}");
        }
}
