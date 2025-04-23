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
		System.out.println("nb list : " + list);
		return list;
	}
	
	@Override
	public KW_DTO_BR_1000MT selectnbnum(int BRD_NO) {
		KW_DTO_BR_1000MT cn = sqls.selectOne("mapper.TB_BR_1000MT.selectnbdetail", BRD_NO);
		System.out.println("nb cn : "+ cn);
		return cn;
	}
	
	@Override
	public int update(KW_DTO_BR_1000MT dto) {
		int cn = sqls.update("mapper.TB_BR_1000MT.updatenbc", dto);
		System.out.println("nb1 cn : "+ cn);
		return cn;
	}
	
	@Override
    public int insert(KW_DTO_BR_1000MT dto) {
		System.out.println("너가 괴롭히는 "+ dto);
        return sqls.insert("mapper.TB_BR_1000MT.insertnbc", dto);
    }
	
	 @Override
	 public int delete(int BRD_NO) {
		 System.out.println("너가 괴롭히는 "+ BRD_NO);
        return sqls.delete("mapper.TB_BR_1000MT.deletenbc", BRD_NO);
    }
}
