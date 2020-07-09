package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.PersonVo;

@Service
public class GuestService {

	@Autowired
	private GuestDao guestdao;
	
	public List<PersonVo> list() {
		System.out.println("userservice:list");
		return guestdao.list();
	}
	
	public int add(PersonVo personvo) {
		System.out.println("userservice:add");
		return guestdao.add(personvo);
	}
	
	public void delete(PersonVo personvo) {
		System.out.println("userservice:delete");
		guestdao.delete(personvo);
	}
}
