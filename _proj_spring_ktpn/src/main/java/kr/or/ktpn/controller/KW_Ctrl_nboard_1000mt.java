package kr.or.ktpn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String detailcontents(@RequestParam("BRD_NO") int BRD_NO, Model model) {
		KW_DTO_BR_1000MT dto = serv.getnbnum(BRD_NO);
		System.out.println("게시글조회 작동테스트");
		
		System.out.println("bn = " +BRD_NO);

		model.addAttribute("dto", dto);
		
		return "writeview_Nam.tiles";
	}
	
	@RequestMapping(value = "/edit_Nam", method = RequestMethod.GET)
	public String detailctedit(
			@RequestParam("BRD_NO")
			int BRD_NO,
			Model model) {
		KW_DTO_BR_1000MT dto = serv.getnbnum(BRD_NO);
		System.out.println("게시글수정 작동테스트");
		
//		System.out.println("bn = " +tl);

		model.addAttribute("dto", dto);
//		
		return "edit_Nam.tiles";
	}
	///////////////////////////////////////
	@RequestMapping(value = "/edit_Nam", method = RequestMethod.POST)
	public String editprocess(Model model,
			@ModelAttribute	KW_DTO_BR_1000MT dto
//			@RequestParam int BRD_NO
			) {
		
		System.out.println("📥 받은 DTO: " + dto);
	    System.out.println("BRD_NO: " + dto.getBRD_NO());
	    System.out.println("제목: " + dto.getTTL_NM());
	    System.out.println("내용: " + dto.getBRD_DESC());
	    
//		KW_DTO_BR_1000MT dto = serv.getnbnum(BRD_NO);
	    int result = serv.getnbupdate(dto);
		model.addAttribute("dto", dto);
		
		System.out.println("🔧 업데이트 결과: " + result);

		return "redirect:/writeview_Nam.tiles?BRD_NO=" + dto.getBRD_NO();
	}
}
