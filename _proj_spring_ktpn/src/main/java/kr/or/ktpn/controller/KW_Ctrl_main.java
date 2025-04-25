package kr.or.ktpn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ktpn.dto.KW_DTO_MB_1000MT;

public class KW_Ctrl_main {

	@RequestMapping("/")
	public String mainPage(HttpSession session, Model model) {
	    KW_DTO_MB_1000MT loginUser = (KW_DTO_MB_1000MT) session.getAttribute("loginUser");

	    if (loginUser == null) {
	        return "redirect:/login";
	    }

	    model.addAttribute("dto", loginUser);
	    return "redirect:/"; // 로그인 성공 후 홈으로
	}
}
