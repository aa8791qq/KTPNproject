package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ktpn.dto.KW_DTO_BR_1000MT;
import kr.or.ktpn.service.KW_Svc_nb_1000mt;

@Controller
public class KW_Ctrl_nboard_1000mt {

	@Autowired
	KW_Svc_nb_1000mt serv;
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String listcontents(Model model) {
		System.out.println("notice 작동테스트");

		List<KW_DTO_BR_1000MT> list = serv.getnboardlist();
		
		System.out.println("list.size : " + list.size());
		
		model.addAttribute("list", list);
		System.out.println("list : " + list);
		
		return "noticeBoard_Nam.tiles";
	}
	
	@RequestMapping(value = "/writeview_Nam", method = RequestMethod.GET)
	public String detailcontents(@RequestParam int tl, Model model) {
		KW_DTO_BR_1000MT dto = serv.getnbnum(tl);
		System.out.println("게시글조회 작동테스트");
		
		System.out.println("bn = " +tl);

		model.addAttribute("dto", dto);
		
		return "writeview_Nam.tiles";
	}
	
	@RequestMapping(value = "/edit_Nam", method = RequestMethod.GET)
	public String detailctedit(
			@RequestParam
//			KW_DTO_BR_1000MT bde,
			int tl,
			Model model) {
		KW_DTO_BR_1000MT dto = serv.getnbnum(tl);
		System.out.println("게시글수정 작동테스트");
		
//		System.out.println("bn = " +tl);

		model.addAttribute("dto", dto);
//		
		return "edit_Nam.tiles";
	}
	
	//@PutMapping(value = "/edit_Nam")
	@RequestMapping(value = "/ktpn/edit_Nam", method = RequestMethod.POST)
	@ResponseBody
	public String editprocess(Model model,
			KW_DTO_BR_1000MT dto,
			@RequestParam int BRD_NO
			) {
		
		System.out.println(BRD_NO);

		int result =serv.getnbupdate(dto);
		System.out.println(result);
		return "result";
	}
}
