package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.ChatDto;
import com.alam.dto.ChatMessageDto;
import com.alam.dto.LoginDto;



public class ChatDao extends SqlMapConfig {
	private String namespace = "chat.mapper.";
	
	public int createChat(ChatDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true) ) {
			res = session.insert(namespace+"createChat", dto);
		}
		
		return res;
	}
	
	public ChatDto checkChatRoom(ChatDto dto) {
		ChatDto chkRoom = null;
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			chkRoom = session.selectOne(namespace+"checkChatRoom", dto);
			session.close();
		}
		
		return chkRoom;
	}
	
	public List<ChatMessageDto> showMessage(String room_Id) {
		List<ChatMessageDto> list = new ArrayList<ChatMessageDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace + "showMessage", room_Id);
			session.close();
		}
		
		return list;
	}
	
	public List<ChatDto> showChatRoom(String guest_Id) {
		List<ChatDto> list = new ArrayList<ChatDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"showChatRoom", guest_Id);
			session.close();
		}
		
		return list;
	}
	
	public int saveMsg(ChatMessageDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace+"saveMsg", dto);
		}
		
		return res;
	}
	
	public List<LoginDto> searchId(String searchId) {
		List<LoginDto> list = new ArrayList<LoginDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"searchId", searchId);
			session.close();
		}
		
		return list;
	}
	
	public int deleteChatRoom(String room_Id) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace+"deleteChatRoom", room_Id);
		}
		
		return res;
	}
	
	public ChatMessageDto lastMsg(String room_Id) {
		ChatMessageDto dto = null;
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			dto = session.selectOne(namespace+"lastMsg", room_Id);
			session.close();
		}
		
		return dto;
	}
}
