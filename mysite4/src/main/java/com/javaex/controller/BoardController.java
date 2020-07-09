package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;



@Controller
public class BoardController {
	
	@Autowired
	BoardService boardservice;
	
	@RequestMapping("/board")
	public String list(Model model) {
		System.out.println("/mysite4/board");
		List<BoardVo> bList = boardservice.list();
		model.addAttribute("bList",bList);
		System.out.println(bList.toString());
		return "board/list";
	}
	
	@RequestMapping("/board/read")
	public String read(@RequestParam("no") int no){
		boardservice.getPerson(no);
		System.out.println("/board/read");
	
		return "board/read";
	}
}
