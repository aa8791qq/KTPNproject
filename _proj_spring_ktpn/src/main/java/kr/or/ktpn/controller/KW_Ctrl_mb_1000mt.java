package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ktpn.dao.KW_DAO_mb_1000mt;
import kr.or.ktpn.dto.DTO_md_1000mt;

@Controller
public class KW_Ctrl_mb_1000mt {

	@Autowired
	KW_DAO_mb_1000mt mb;
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String listMember() {
		System.out.println("member 불러와본다?");

		List<DTO_md_1000mt> list = mb.
		return "login";
	}
	
}
