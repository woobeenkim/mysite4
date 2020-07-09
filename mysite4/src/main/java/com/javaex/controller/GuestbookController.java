package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.PersonVo;



@Controller
public class GuestbookController {
	
	@Autowired
	private GuestService guestservice;
	
	@RequestMapping("/guest")
	public String guest() {
		System.out.println("/guest");
		return "guest/addlist";
	}
	
	@RequestMapping("/guest/list")
	public String list(Model model) {
		List<PersonVo> pList = guestservice.list();
		model.addAttribute("pList",pList);
		System.out.println("/guest/list");
		System.out.println(pList.toString());
		return "guest/addlist";
	}
	
	@RequestMapping("guest/add")
	public String insert(@ModelAttribute PersonVo personvo){
		System.out.println("guest/add");
		System.out.println(personvo.toString());
		guestservice.add(personvo);
		
		return "redirect:/guest/list";
	}
	
	@RequestMapping("guest/dform")
	public String dform(@RequestParam("no") int no) {
		System.out.println(no);
		
		return "guest/deleteForm";
	}
	
	@RequestMapping("guest/delete")
	public String delete(@ModelAttribute PersonVo personvo,
			 			 @RequestParam("no") int no) {
		System.out.println(personvo.toString());
		guestservice.delete(personvo);
		return "redirect:/guest/list";
	}
	
	

}
