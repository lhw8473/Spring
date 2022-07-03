package com.spring.pr.user.mapper;

import com.spring.pr.command.UserVO;

public interface IUserMapper {
	
	// 아이디 중복 체크 
	boolean checkId(String userId);
	
	// 아이디 등록 
	void registUser(UserVO user);
	
	// 유저 정보 가져오기 
	UserVO getUser(UserVO user);
	
	// 유저 비밀번호 변경 
	void chUserPw(UserVO user);
	
	// 유저 정보 변경 
	void chUser(UserVO user);
	
	// 유저 삭제 
	void delUser(UserVO user);

}