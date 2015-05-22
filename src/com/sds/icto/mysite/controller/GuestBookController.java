package com.sds.icto.mysite.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.domain.GuestBookVo;
import com.sds.icto.mysite.repository.GuestBookDao;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	GuestBookDao guestbookDao;
	
	@RequestMapping({"","/list"})
	public String guestBookList(Model model){
		List<GuestBookVo> list =null;
		try {
			list = guestbookDao.fetch();
			model.addAttribute("list",list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "guestbook/list";
	}
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestBookVo vo){
		try {
			guestbookDao.guestBookInsert(vo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteForm(
			){
		return "guestbook/deleteform";
	}

	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo vo,@RequestParam String no){
		try {
			guestbookDao.guestBookDelete(no, vo.getPassword());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
}
