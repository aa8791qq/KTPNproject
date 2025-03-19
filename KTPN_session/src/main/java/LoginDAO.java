import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {

	public List selectLoginList() {

		System.out.println("아잉실행");
		List resultList = new ArrayList();

		try {
			// db 접속 시작
			// context.xml에서 Resource 중에 jdbc/oracle을 가져와야 함.
			// JNDI 방식으로 가져옴
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보를 가져오기
			// 접속이 안되면 null(id, pw 불일치 상황)
			Connection con = ds.getConnection(); // null 방어코딩해야됨

			// SQL 준비
			String query = "select * from emp"; // 여러줄로 쓸때에는 공백삽입을 주의해야함(변경가능)
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과확보
			// ResultSet executeQuery : SQL 중 select 실행
			// int executeUpdate : select 외 모든것
			// ResultSet : select 조회 결과 전체(엑셀테이블와 유사)
			ResultSet rs = ps.executeQuery();

			// 결과활용
//						rs.next(); 	// 다음줄로 커서를 이동(1번째 줄)
			// 다음줄이 있으면 true, 없으면 false를 return
//						List<Map> list = new ArrayList<Map>();
//			List<EmpDTO> list = new ArrayList<EmpDTO>();
			while (rs.next()) { // 다음줄이 없을때 까지 반복
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");

				System.out.println("----------------------------------");
				System.out.println(empno);
				System.out.println(ename);
				System.out.println(hiredate);

				// 실무적인 방식
				LoginDTO loginDTO = new LoginDTO();
				

				resultList.add(loginDTO);

			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultList;
	}

}
