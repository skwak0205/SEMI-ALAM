package com.alam.dto;

import java.util.Date;

public class BoardDto {
	public int board_no;
	public String board_category;
	public String board_main_id;
	public String board_main_title;
	public String board_main_content;
	public Date board_main_date;
	public int board_main_views;
	public String board_main_secret;
	public String board_reply_no;
	public String board_main_fileid;
	public String board_main_fileloc;
	public int startPage;
	public int endPage;

	public BoardDto() {
	}

	public BoardDto(int board_no, String board_category, String board_main_id, String board_main_title,
			String board_main_content, Date board_main_date, String board_main_secret, String board_main_fileid,
			String board_main_fileloc) {
		this.board_no = board_no;
		this.board_category = board_category;
		this.board_main_id = board_main_id;
		this.board_main_title = board_main_title;
		this.board_main_content = board_main_content;
		this.board_main_date = board_main_date;
		this.board_main_secret = board_main_secret;
		this.board_main_fileid = board_main_fileid;
		this.board_main_fileloc = board_main_fileloc;
	}

	// 전체 생성자
	public BoardDto(int board_no, String board_category, String board_main_id, String board_main_title,
			String board_main_content, Date board_main_date, int board_main_views, String board_main_secret,
			String board_reply_no, String board_main_fileid, String board_main_fileloc) {
		this.board_no = board_no;
		this.board_category = board_category;
		this.board_main_id = board_main_id;
		this.board_main_title = board_main_title;
		this.board_main_content = board_main_content;
		this.board_main_date = board_main_date;
		this.board_main_views = board_main_views;
		this.board_main_secret = board_main_secret;
		this.board_reply_no = board_reply_no;
		this.board_main_fileid = board_main_fileid;
		this.board_main_fileloc = board_main_fileloc;
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

	public String getBoard_main_id() {
		return board_main_id;
	}

	public void setBoard_main_id(String board_main_id) {
		this.board_main_id = board_main_id;
	}

	public String getBoard_main_title() {
		return board_main_title;
	}

	public void setBoard_main_title(String board_main_title) {
		this.board_main_title = board_main_title;
	}

	public String getBoard_main_content() {
		return board_main_content;
	}

	public void setBoard_main_content(String board_main_content) {
		this.board_main_content = board_main_content;
	}

	public Date getBoard_main_date() {
		return board_main_date;
	}

	public void setBoard_main_date(Date board_main_date) {
		this.board_main_date = board_main_date;
	}

	public int getBoard_main_views() {
		return board_main_views;
	}

	public void setBoard_main_views(int board_main_views) {
		this.board_main_views = board_main_views;
	}

	public String getBoard_main_secret() {
		return board_main_secret;
	}

	public void setBoard_main_secret(String board_main_secret) {
		this.board_main_secret = board_main_secret;
	}

	public String getBoard_reply_no() {
		return board_reply_no;
	}

	public void setBoard_reply_no(String board_reply_no) {
		this.board_reply_no = board_reply_no;
	}

	public String getBoard_main_fileid() {
		return board_main_fileid;
	}

	public void setBoard_main_fileid(String board_main_fileid) {
		this.board_main_fileid = board_main_fileid;
	}

	public String getBoard_main_fileloc() {
		return board_main_fileloc;
	}

	public void setBoard_main_fileloc(String board_main_fileloc) {
		this.board_main_fileloc = board_main_fileloc;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
