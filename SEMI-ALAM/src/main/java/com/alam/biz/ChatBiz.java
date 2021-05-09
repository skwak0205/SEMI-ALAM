package com.alam.biz;

import java.util.List;

import com.alam.dao.ChatDao;
import com.alam.dto.ChatDto;
import com.alam.dto.ChatMessageDto;
import com.alam.dto.LoginDto;

public class ChatBiz {
	private ChatDao dao = new ChatDao();
	
	public int createChat(ChatDto dto) {
		return dao.createChat(dto);
	}
	
	public ChatDto checkChatRoom(ChatDto dto) {
		return dao.checkChatRoom(dto);
	}
	
	public List<ChatMessageDto> showMessage(String room_Id){
		return dao.showMessage(room_Id);
	}
	
	public List<ChatDto> showChatRoom(String guest_Id) {
		return dao.showChatRoom(guest_Id);
	}
	
	public int saveMsg(ChatMessageDto dto) {
		return dao.saveMsg(dto);
	}
	
	public List<LoginDto> searchId(String searchId) {
		return dao.searchId(searchId);
	}
	
	public int deleteChatRoom(String room_Id) {
		return dao.deleteChatRoom(room_Id);
	}
	
	public ChatMessageDto lastMsg(String room_Id) {
		return dao.lastMsg(room_Id);
	}
}
