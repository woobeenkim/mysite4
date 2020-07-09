package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class GuestDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<PersonVo> list(){
		List<PersonVo> personList = sqlSession.selectList("guestbook.getList");
		return personList;
		
	}
	
	public int add(PersonVo personvo) {
		System.out.println("userdao:add");
		return sqlSession.insert("guestbook.add", personvo);
		
	}
	
	public void delete(PersonVo personvo) {
		System.out.println("userdao:delete");
		sqlSession.delete("guestbook.delete", personvo);
	}
}
