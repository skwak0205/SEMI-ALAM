package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dao.SqlMapConfig;
import com.alam.dto.LoginDto;

public class MemberDaoImpl extends SqlMapConfig implements MemberDao {

	private String namespace = "com.login.mapper.";

	@Override
	public List<LoginDto> memberSelectList() {

		List<LoginDto> list = new ArrayList<LoginDto>();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace + "memberSelectList");
			session.close();
		}

		return list;
	}

	@Override
	public int updateRole(LoginDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.update(namespace + "updateRole", dto);
		}

		return res;
	}

	@Override
	public LoginDto memberLogin(LoginDto dto) {
		LoginDto user;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			user = session.selectOne(namespace + "memberLogin", dto);
			session.close();
		}

		return user;
	}

	@Override
	public int memberLoginInsert(LoginDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace + "memberLoginInsert", dto);
		}

		return res;
	}

	@Override
	public LoginDto idCheck(String member_id) {

		LoginDto dto = new LoginDto();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			dto = session.selectOne(namespace + "idCheck", member_id);
			session.close();
		}

		return dto;
	}

	@Override
	public LoginDto memberLoginSelectOne(String member_id) {

		LoginDto dto = new LoginDto();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			dto = session.selectOne(namespace + "memeberLoginSelectOne", member_id);
			session.close();
		}

		return dto;
	}

	@Override
	public int memberLoginUpdate(LoginDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.update(namespace + "memberLoginUpdate", dto);
		}
		return res;
	}

	@Override
	public int memberLoginDelete(String member_id) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace + "memberLoginDelete", member_id);
		}

		return res;
	}

	@Override
	public LoginDto memberCategorySelect(LoginDto dto) {

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			dto = session.selectOne(namespace + "memeberCategorySelect", dto);
			session.close();
		}

		return dto;
	}

	@Override
	public String memberLoginIdYn(String member_id) {

		String memberIdYn = "";

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			memberIdYn = session.selectOne(namespace + "memberLoginIdYn", member_id);
		}

		return memberIdYn;
	}
	
	public LoginDto checkUser(LoginDto dto) {
		LoginDto user = null;
		
		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			user = session.selectOne(namespace+"checkUser", dto);
			session.close();
		}
		
		return user;
	}
	
	public int updatePw(LoginDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.update(namespace+"updatePw", dto);
		}
		
		return res;
	}
	
	public LoginDto getSalt(String member_id) {
		LoginDto dto = null;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			dto = session.selectOne(namespace+"getSalt", member_id);
			session.close();
		}
		
		return dto;
	}
	
	public int approve(String member_id) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.update(namespace+"approve", member_id);
		}
		
		return res;
	}

}
