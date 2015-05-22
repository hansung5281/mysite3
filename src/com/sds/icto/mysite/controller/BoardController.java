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

import com.sds.icto.mysite.domain.BoardVo;
import com.sds.icto.mysite.repository.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping({"","/list"})
	public String list(Model model){
		List<BoardVo> list =null;
		try {
			list = boardDao.simFetch();
			model.addAttribute("list",list);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "board/list";
	}
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String writeFrom(){
		return "board/write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo vo){
		try {
			boardDao.boardInsert(vo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/board";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Long no){
		try {
			boardDao.boardDelete(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/board";
	}

	
	
	@RequestMapping("/view")
	public String view(@RequestParam Long no,@RequestParam Long view_cnt,Model model){
			BoardVo list =null;
			try {
				list = boardDao.deFetch(no,view_cnt);
				model.addAttribute("list",list);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		return "board/view";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyForm(@RequestParam Long no,Model model){
		BoardVo list =null;
		try {
			list = boardDao.deFetch(no);
			model.addAttribute("list",list);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "board/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(@ModelAttribute BoardVo vo,@RequestParam Long no){
		vo.setNo(no);
		try {
			boardDao.boardChange(vo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/board";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam String keyword, Model model){
		List<BoardVo> list =null;
		try {
			list = boardDao.searchByTitle(keyword);
			System.out.println(list.size());
			model.addAttribute("list",list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "board/list";
	}
	
	
}
