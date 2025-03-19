

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
//		List resultList3 = memberDAO.selectMemberOne(MemberDTO memberDTO);
//		List resultList2 = memberDAO.updateMember(MemberDTO memberDTO);
		
		for(int i = 0; i<resultList.size(); i++) {
			MemberDTO dto = new MemberDTO();
			dto = (MemberDTO) resultList.get(i);
			System.out.println("dto.id : " + dto.getId());
			System.out.println("dto.pw : " + dto.getPw());
			
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
		
		System.out.println("dopost 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String check = request.getParameter("checking");
		System.out.println("check : "+ check);

		MemberDTO mDTO = new MemberDTO();
		
		String str_mid = request.getParameter("id");
		System.out.println(str_mid);
		
		String str_mpw = request.getParameter("pw");
		System.out.println(str_mpw);
		
		
		// dto id, pw 넣고
		// dao 메소드 전달, dao에서 출력
		
		mDTO.setId(str_mid);
		mDTO.setPw(str_mpw);
		
		
		
		
		
		
		/// 나중에
		
		MemberDAO mDAO = new MemberDAO();
		
		List result = mDAO.selectMember();
		System.out.println(result);
		
		
		
		
//		if(str_mid == mDTO.id && str_mpw == mDTO.pw) {
//			System.out.println("로그인성공");
//		} else {
//			System.out.println("실패");
//		}
		
		
		
		
//		String url = "dashBoard_kwak.html";
//		response.sendRedirect(url);
		
//		mDTO.setId(str_mid);
//		mDTO.setPw(str_mpw);
	}

}
