package com.alam.biz;

import java.util.List;

import com.alam.dto.LoginDto;

public interface MemberBiz {

	// 관리자
	public List<LoginDto> memberSelectList();                // 전체조회
	public int updateRole(LoginDto dto);			         // 멘토,멘티 전환
		
	// 공통 기능
	public LoginDto memberLogin(LoginDto dto);		         // 로그인
	public int memberLoginInsert(LoginDto dto);		         // 회원가입
	public LoginDto idCheck(String member_id);			     // 아이디 중복체크	
	public LoginDto memberLoginSelectOne(String member_id);  // 내정보조회
	public int memberLoginUpdate(LoginDto dto);		         // 내정보수정	
	public int memberLoginDelete(String member_id);		     // 회원탈퇴
	public String memberLoginIdYn(String member_id);		 // 회원가입유무
	// 회원가입용 카테고리
	public LoginDto memberCategorySelect(LoginDto dto);
	
	public LoginDto checkUser(LoginDto dto);
	
	public int updatePw(LoginDto dto);
	
	public LoginDto getSalt(String member_id);
	
	public int approve(String member_id);
}
