package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	//Autowired는  web.xml에 context-listener설정 및  applicationContext.xml 설정 한 후 사용 가능
	//처음 설계시 각 설계마다 sysout을 통하여 그부분에 문제가 없는지 출력확인.
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/user/jform")
	public String joinForm() {
		System.out.println("user/joinform");
		return "user/joinForm";	
	}
	
	@RequestMapping("/user/join")
	public String join(@ModelAttribute UserVo uservo) {
		System.out.println("user/join");
		System.out.println(uservo.toString());
		userservice.join(uservo);
		
		return "redirect:/user/joinOk";
	}
	
	@RequestMapping("/user/joinOk")
	public String joinok(){
		
		return "user/joinOk";
	}
	
	@RequestMapping("/user/lform")
	public String lform() {
		System.out.println("user/loginform");
		return "user/loginForm";
	}
	
	@RequestMapping("/user/login")
	public String login(@ModelAttribute UserVo uservo, HttpSession session) {
		System.out.println("usercontroller/login");
		
		UserVo authUser = userservice.login(uservo);
		
		if(authUser != null) {
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}else {
			System.out.println("로그인 실패");
			return "redirect:/user/lform?result=fail";
		}
	
	}
	
	@RequestMapping("/user/mform")
	public String mform(Model model,
						@RequestParam("no") int no) {
		System.out.println("user/modifyform");
		UserVo uservo = userservice.getUser(no);
		System.out.println(uservo);
		model.addAttribute("uservo",uservo);
		
		return "user/modifyForm";
	}
	
	@RequestMapping("/user/modify")
	public String modify(@ModelAttribute UserVo uservo, HttpSession session) {
		userservice.modiUser(uservo);
		UserVo vo = (UserVo)session.getAttribute("authUser");
		vo.setName(uservo.getName());
		System.out.println(vo);
		return "redirect:/main";
	}
	
	@RequestMapping("user/logout")
	public String logout(@ModelAttribute UserVo uservo,
						 HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();
		return"redirect:/main";
	}
	
	
}
