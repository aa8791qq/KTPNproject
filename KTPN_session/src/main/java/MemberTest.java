

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mtest")
public class MemberTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		List resultList = memberDAO.selectMember();
//		List resultList2 = memberDAO.updateMember(MemberDTO memberDTO);
		
		for(int i = 0; i<resultList.size(); i++) {
			MemberDTO dto = new MemberDTO();
			dto = (MemberDTO) resultList.get(i);
			System.out.println("dto.id : " + dto.getId());
			
		}
		request.setAttribute("resultList", resultList);
		System.out.println(resultList);

		// /로 시작하면 webapp을 뜻한다
		// WEB-INF 폴더는 보안영역이라서 브라우저에서는 접근할 수 없다
//				String url = "/WEB-INF/list.jsp";
		String url = "/login.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		System.out.println("command : "+ command);
		
		String str_mid = request.getParameter("ID");
		System.out.println(str_mid);
		
		String url = "mtest";
		response.sendRedirect(url);
	}

}
