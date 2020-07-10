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
	
	public void phit(BoardVo boardvo) {
		boarddao.phit(boardvo);
	}
	
	public BoardVo getPerson(int no) {
		System.out.println("boardservice : getPerson");
		return boarddao.getPerson(no);
	}
	
	public void delete(int no) {
		System.out.println("boardservice : delete");
		boarddao.delete(no);
	}
	
	public int add(BoardVo boardvo) {
		System.out.println("boardservice : add");
		return boarddao.add(boardvo);
	}
	
	public List<BoardVo> search(String title){
		System.out.println("boardservice : search");
		System.out.println(title);
		return boarddao.search(title);
	}
}
