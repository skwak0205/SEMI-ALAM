package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.BoardDto;
import com.alam.dto.ClassApplyDto;

public class ClassApplyDao extends SqlMapConfig {
	
	private String namespace = "com.classApply.mapper.";
	
	public List<ClassApplyDto> selectList(int category){
		List<ClassApplyDto> list = new ArrayList<ClassApplyDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)){
			list = session.selectList(namespace+"selectList", category);
			session.close();
		}
		
		return list;
	}
	
	public int classInsert(ClassApplyDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			res = session.insert(namespace+"classInsert", dto);
		}
		
		return res;
	}
	
	public ClassApplyDto classDetail(int class_apply_no) {
		ClassApplyDto dto = null;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)){
			dto = session.selectOne(namespace+"selectOne", class_apply_no);
		}
		
		return dto;
	}
	
	public int classUpdate(ClassApplyDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace + "classUpdate", dto);
		}

		return res;
	}

	public int classDelete(int class_apply_no) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace + "classDelete", class_apply_no);
		}

		return res;
	}

}
