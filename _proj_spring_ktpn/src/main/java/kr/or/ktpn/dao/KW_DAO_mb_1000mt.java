package kr.or.ktpn.dao;

import java.util.List;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;

public interface KW_DAO_mb_1000mt {

	public List<KW_DTO_MB_1000MT> selectMember();
	public KW_DTO_MB_1000MT selectMbOne(String id);
}
