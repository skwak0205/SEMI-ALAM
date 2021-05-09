package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.UploadDto;

public class UploadDao extends SqlMapConfig {
	private String namespace = "upload.mapper.";
	
	public int upload(UploadDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace+"upload", dto);
		}
		
		return res;
	}
	
	public List<UploadDto> uploadList(int category) {
		List<UploadDto> list = new ArrayList<UploadDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"uploadList", category);
		}
		
		return list;
	}
	
	public int delete(UploadDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace+"delete", dto);
		}
		
		return res;
	}

}
