package com.alam.dto;

import java.util.Date;

public class ChatMessageDto {
	private int room_seq;
	private String room_id;
	private String from_id;
	private String to_id;
	private String message;
	private Date send_date;
	
	public ChatMessageDto() {
		
	}

	public ChatMessageDto(int room_seq, String room_id, String from_id, String to_id, String message,
			Date send_date) {
		this.room_seq = room_seq;
		this.room_id = room_id;
		this.from_id = from_id;
		this.to_id = to_id;
		this.message = message;
		this.send_date = send_date;
	}

	public int getRoom_seq() {
		return room_seq;
	}

	public void setRoom_seq(int room_seq) {
		this.room_seq = room_seq;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getFrom_id() {
		return from_id;
	}

	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	public String getTo_id() {
		return to_id;
	}

	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	
}
