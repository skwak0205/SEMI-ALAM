package com.alam.biz;

import java.util.List;

import com.alam.dao.MemberDao;
import com.alam.dao.MemberDaoImpl;
import com.alam.dto.LoginDto;

public class MemberBizImpl implements MemberBiz {

	private MemberDao dao = new MemberDaoImpl();

	@Override
	public List<LoginDto> memberSelectList() {
		return dao.memberSelectList();
	}

	@Override
	public int updateRole(LoginDto dto) {
		return dao.updateRole(dto);
	}

	@Override
	public LoginDto memberLogin(LoginDto dto) {
		return dao.memberLogin(dto);
	}

	@Override
	public int memberLoginInsert(LoginDto dto) {
		return dao.memberLoginInsert(dto);
	}

	@Override
	public LoginDto idCheck(String member_id) {
		return dao.idCheck(member_id);
	}

	@Override
	public LoginDto memberLoginSelectOne(String member_id) {
		return dao.memberLoginSelectOne(member_id);
	}

	@Override
	public int memberLoginUpdate(LoginDto dto) {
		return dao.memberLoginUpdate(dto);
	}

	@Override
	public int memberLoginDelete(String member_id) {
		return dao.memberLoginDelete(member_id);
	}

	@Override
	public LoginDto memberCategorySelect(LoginDto dto) {
		return dao.memberCategorySelect(dto);
	}

	@Override
	public String memberLoginIdYn(String member_id) {
		return dao.memberLoginIdYn(member_id);
	}
	
	public LoginDto checkUser(LoginDto dto) {
		return dao.checkUser(dto);
	}
	
	public int updatePw(LoginDto dto) {
		return dao.updatePw(dto);
	}
	
	public LoginDto getSalt(String member_id) {
		return dao.getSalt(member_id);
	}
	
	public int approve(String member_id) {
		return dao.approve(member_id);
	}

}
