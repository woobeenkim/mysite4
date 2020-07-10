package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> list(){
		List<BoardVo> boardlist = sqlSession.selectList("board.getList");
		return boardlist;
	}
	
	public BoardVo getPerson(int no) {
		System.out.println(no);
		BoardVo boardvo = sqlSession.selectOne("board.getPerson",no);
		return boardvo;
	}
	
	public void phit(BoardVo boardvo) {
		sqlSession.update("board.phit", boardvo);
	}
	
	public void delete(int no) {
		System.out.println(no);
		sqlSession.delete("board.delete", no);
	}
	
	public int add(BoardVo boardvo) {
		System.out.println(boardvo);
		int add = sqlSession.insert("board.add", boardvo);
		return  add;
	}
	public List<BoardVo> search(String title){
		List<BoardVo> boardlist = sqlSession.selectList("board.search", title);
		return boardlist;
	}
}
