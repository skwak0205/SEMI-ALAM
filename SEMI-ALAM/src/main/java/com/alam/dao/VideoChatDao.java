package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.VideoDto;


public class VideoChatDao extends SqlMapConfig {
	
private String namespace = "video.mapper.";
	
	public int createRoom(VideoDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace + "createRoom", dto);
		}
		
		return res;
	}
	
	public List<VideoDto> showVideoRoom(String mentee_id) {
		List<VideoDto> list = new ArrayList<VideoDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"showVideoRoom", mentee_id);
			session.close();
		}
		
		return list;
	}
	
	public List<VideoDto> showVideoRoomMentor(String mentor_id) {
		List<VideoDto> list = new ArrayList<VideoDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"showVideoRoomMentor", mentor_id);
			session.close();
		}
		
		return list;
	}
	
	public int deleteRoom(String room_Id) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace+"deleteRoom", room_Id);
		}
		
		return res;
	}
}
