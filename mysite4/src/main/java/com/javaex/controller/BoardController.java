package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String read(Model model,
					   @RequestParam("no") int no,
					   @RequestParam("hit") int hit){
		BoardVo boardvo = boardservice.getPerson(no);
		model.addAttribute("boardvo",boardvo);
		boardservice.phit(boardvo);
		System.out.println(boardvo);
		System.out.println("/board/read");
		
		return "board/read";
	}
	
	@RequestMapping("/board/wform")
	public String wform() {
		System.out.println("/board/wform");
		return "board/writeForm";
	}
	
	@RequestMapping("/board/add")
	public String add(@ModelAttribute BoardVo boardvo) {
		System.out.println("/board/add");
		boardservice.add(boardvo);
		return "redirect:/board";
	}
	
	@RequestMapping("/board/delete")
	public String delete(@RequestParam("no") int no){
		boardservice.delete(no);
		return "redirect:/board";
	}
	
	@RequestMapping("/board/mform")
	public String mform() {
		System.out.println("/board/mform");
		return "board/modifyForm";
	}
	
	@RequestMapping("board/search")
	public String search(Model model,
			@RequestParam("title") String title) {
		System.out.println("board/search");
		List<BoardVo> bList = boardservice.search(title);
		model.addAttribute("bList",bList);
		return "board/list";
	}
}
