package com.alam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.ApplyMentorDto;
import com.alam.dto.BoardDto;
import com.alam.dto.LoginDto;

public class AdminDao extends SqlMapConfig {

	private String namespace = "com.admin.mapper.";

	public List<BoardDto> searchList(String query) {

		SqlSession session = getSqlSessionFactory().openSession();
		List<BoardDto> list = session.selectList(namespace + "searchList", query);
		session.close(); // session 안닫아주면 에러남

		return list;
	}

	public LoginDto searchId(String query) {
		LoginDto dto = new LoginDto();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			dto = session.selectOne(namespace + "searchId", query);
			session.close();
		}

		return dto;
	}

	public List<LoginDto> memberListAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<LoginDto> list = session.selectList(namespace + "memberListAll");
		session.close(); // session 안닫아주면 에러남

		return list;
	}

	public int adminDelMember(String member_id) {

		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace + "adminDelMember", member_id);
		}

		return res;
	}

	public List<BoardDto> adminComplaint() {

		SqlSession session = getSqlSessionFactory().openSession();
		List<BoardDto> list = session.selectList(namespace + "adminComplaint");
		session.close();

		return list;
	}

	public List<BoardDto> adminAsk() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<BoardDto> list = session.selectList(namespace + "adminAsk");
		session.close();

		return list;
	}
	
//	public List<BoardDto> searchList(String query) {
//
//		SqlSession session = getSqlSessionFactory().openSession();
//		List<BoardDto> list = session.selectList("com.admin.mapper." + "searchList", query);
//		session.close(); 
//		
//		return list;
//	}
	
	public List<ApplyMentorDto> apply_list() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<ApplyMentorDto> list = session.selectList("applyMentor.mapper." + "selectList");
		session.close();

		return list;
	}
}
