package kr.or.ktpn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

@Repository
public class KW_DAO_nboard_1000mtimpl implements KW_DAO_nboard_1000mt {

	@Autowired
	SqlSession sqls;
	
	@Override
	public List<KW_DTO_BR_1000MT> selectnBoard(){
		List<KW_DTO_BR_1000MT> list = sqls.selectList("mapper.TB_BR_1000MT.selectnbc");
		System.out.println("fb list : " + list);
		return list;
	}
	
	@Override
	public KW_DTO_BR_1000MT selectnbnum(int num) {
		KW_DTO_BR_1000MT cn = sqls.selectOne("mapper.TB_BR_1000MT.selectselectnbcone", num);
		System.out.println("fb cn : "+ cn);
		return cn;
	}
	
	
}
