package com.alam.dao;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.ApplyMentorDto;

public class ApplyMentorDao extends SqlMapConfig {
	private String namespace = "applyMentor.mapper.";

	public int insert(ApplyMentorDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"insert", dto);
		}
		
		return res;
	}
	
	public int deleteApproved(String mentorId) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.delete(namespace+"deleteApproved", mentorId);
		}
		
		return res;
	}
}
