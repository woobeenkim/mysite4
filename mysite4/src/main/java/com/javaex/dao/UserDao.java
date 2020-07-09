package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	
	@Autowired
	private SqlSession sqlSession;
	//회원가입
	
	public int insert(UserVo uservo) {
		
		System.out.println("userdao:insert");
		return sqlSession.insert("user.insert", uservo);
		
	}
	
	
	public UserVo selectUser(UserVo uservo){
		System.out.println(uservo.toString());
		System.out.println("userdao:selectUser");
		UserVo authUser = sqlSession.selectOne("user.selectUser", uservo);
		return authUser;
	}
	
	public UserVo getUser(int no) {
		System.out.println(no);
		System.out.println("userdao:getUser");
		UserVo uservo = sqlSession.selectOne("user.getUser", no);
		return uservo;
	}
	
	public int modiUser(UserVo uservo) {
		System.out.println(uservo.toString());
		System.out.println("userdao:modiUser");
		return sqlSession.update("user.modiUser", uservo);
	}
	
	
	
}
