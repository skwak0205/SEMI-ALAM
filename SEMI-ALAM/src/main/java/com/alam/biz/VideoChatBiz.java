package com.alam.biz;

import java.util.List;

import com.alam.dao.VideoChatDao;
import com.alam.dto.VideoDto;


public class VideoChatBiz {
private VideoChatDao dao = new VideoChatDao();
	
	public int createRoom(VideoDto dto) {
		return dao.createRoom(dto);
	}
	
	public List<VideoDto> showVideoRoom(String mentee_id) {
		return dao.showVideoRoom(mentee_id);
	}
	
	public List<VideoDto> showVideoRoomMentor(String mentor_id) {
		return dao.showVideoRoomMentor(mentor_id);
	}
	
	public int deleteRoom(String room_id) {
		return dao.deleteRoom(room_id);
	}
}
