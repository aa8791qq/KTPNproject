package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;

public interface KW_DAO_nboard_1000mt {
	
	List<KW_DTO_BR_1000MT> selectnBoard();
	public KW_DTO_BR_1000MT selectnbnum(int tl);

}
