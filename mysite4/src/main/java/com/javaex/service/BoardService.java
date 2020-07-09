package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boarddao;
	
	public List<BoardVo> list(){
		System.out.println("boardservice : list");
		return boarddao.list();
	}
	public BoardVo getPerson(int no) {
		System.out.println("boardservice : getPerson");
		return boarddao.getPerson(no);
	}
}
