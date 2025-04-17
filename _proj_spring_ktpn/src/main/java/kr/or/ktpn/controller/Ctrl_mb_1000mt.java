package kr.or.ktpn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ctrl_mb_1000mt {

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String listMember() {
		System.out.println("member 불러와본다?");
		
		
		return "login";
	}
	
}
