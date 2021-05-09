package com.alam.dto;

import java.util.Date;

public class ChatDto {
	private int chat_no;
	private String room_id;
	private String creator_id;
	private String guest_id;
	private Date create_date;
	
	public ChatDto() {
		
	}

	public ChatDto(int chat_no, String room_id, String creator_id, String guest_id, Date create_date) {
		this.chat_no = chat_no;
		this.room_id = room_id;
		this.creator_id = creator_id;
		this.guest_id = guest_id;
		this.create_date = create_date;
	}

	public int getChat_no() {
		return chat_no;
	}

	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}

	public String getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(String guest_id) {
		this.guest_id = guest_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	
}
