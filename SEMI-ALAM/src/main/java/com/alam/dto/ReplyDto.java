package com.alam.dto;

import java.util.Date;

public class ReplyDto {
	private int reply_no;
	private int board_no;
	private String board_category;
	private String reply_id;
	private String reply_content;
	private Date reply_date;
	
	public ReplyDto() {
		
	}

	public ReplyDto(int reply_no, int board_no, String board_category, String reply_id, String reply_content,
			Date reply_date) {
		this.reply_no = reply_no;
		this.board_no = board_no;
		this.board_category = board_category;
		this.reply_id = reply_id;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public String getReply_id() {
		return reply_id;
	}

	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
}
