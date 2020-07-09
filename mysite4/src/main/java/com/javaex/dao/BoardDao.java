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
}
