package com.sds.icto.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	// 링크는 겟방식
	public String joinForm() {
		return "member/joinform";
	}
	
	@RequestMapping(value= "/join", method=RequestMethod.POST)
	public String insert(@ModelAttribute MemberVo vo){
		memberService.joinUser(vo);
		return "redirect:/member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginform";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberVo vo,HttpSession session) {
		
		MemberVo memberVO = memberService.authUser(vo);

		if (memberVO == null) {
			return "redirect:/member/login?result=fail";
		}

		session.setAttribute("authMember", memberVO);
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authMember");
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping(value="/uinfo",method = RequestMethod.GET)
	public String uinfoForm() {
		return "member/uinfoform";
	}
	
	@RequestMapping(value="/uinfo",method = RequestMethod.POST)
	public String uinfo(@ModelAttribute MemberVo vo,HttpSession session,
							@RequestParam Long no) {
		MemberVo memberVO=null;
		vo.setNo(no);
		memberService.changeUser(vo);
		memberVO = memberService.authUser(vo);
		session.setAttribute("authMember", memberVO);
		
		return "member/uinfoform";
	}
	
}
