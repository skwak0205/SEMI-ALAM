package com.alam.dto;

import java.util.Date;

public class VideoDto {
	private int room_no;
	private String room_id;
	private String room_title;
	private String mentor_id;
	private String mentee_id;
	private Date create_date;

	public VideoDto() {

	}

	public VideoDto(int room_no, String room_id, String room_title, String mentor_id, String mentee_id, Date create_date) {
		this.room_no = room_no;
		this.room_id = room_id;
		this.room_title = room_title;
		this.mentor_id = mentor_id;
		this.mentee_id = mentee_id;
		this.create_date = create_date;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getRoom_title() {
		return room_title;
	}

	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}

	public String getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(String mentor_id) {
		this.mentor_id = mentor_id;
	}

	public String getMentee_id() {
		return mentee_id;
	}

	public void setMentee_id(String mentee_id) {
		this.mentee_id = mentee_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
