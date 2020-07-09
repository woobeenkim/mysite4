package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	
	public int join(UserVo uservo) {
		System.out.println("userservice:join");
		return userdao.insert(uservo);
	}
	
	public UserVo login(UserVo uservo) {
		System.out.println("userservice:login");
		UserVo authUser = userdao.selectUser(uservo);
		return authUser;
	}
	public UserVo getUser(int no) {
		System.out.println("userservice:mform");
		UserVo uservo = userdao.getUser(no);
		return uservo;
	}
	public int modiUser(UserVo uservo) {
		System.out.println("userservice:modify");
		return userdao.modiUser(uservo);
	}
}
