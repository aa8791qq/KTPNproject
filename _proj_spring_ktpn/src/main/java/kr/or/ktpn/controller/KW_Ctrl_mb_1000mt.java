package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;
import kr.or.ktpn.service.KW_Svc_mb_1000mt;

@Controller
public class KW_Ctrl_mb_1000mt {

	@Autowired
	KW_Svc_mb_1000mt serv;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String listMember(Model model) {
		System.out.println("맴버관리창 들어간다능");

		List<KW_DTO_MB_1000MT> list = serv.getMemberlist();
		
		System.out.println("list.size : " + list.size());
		
		model.addAttribute("list", list);
		
		return "/main/memberManger";
	}
	
	@RequestMapping(value = "/memberdatail", method = RequestMethod.GET)
	public String detail(@RequestParam String id, Model model) {
		KW_DTO_MB_1000MT dto = serv.getMemberId(id);
		
		System.out.println("id = " + id);
		System.out.println("dto = " + dto);
		
		model.addAttribute("dto", dto);
		return "/main/memberdatail";
	}
	
//	@RequestMapping(value = "/loginone", method = RequestMethod.GET) // 로그인 인증프로세스 만들거임(미개봉)
//	public String oneMember(
//			@ModelAttribute
//			KW_DTO_MB_1000MT dto) {
//		System.out.println("login창 들어간다능");
//		
//		KW_DTO_MB_1000MT result = serv.getMemberone(dto);
//		
//		System.out.println("result : " + result);
//		
//		return "/login/login";
//	}
}
