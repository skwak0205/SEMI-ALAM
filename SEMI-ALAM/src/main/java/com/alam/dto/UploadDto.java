package com.alam.dto;

import java.util.Date;

public class UploadDto {
	private int upload_no;
	private String upload_id;
	private String upload_title;
	private int upload_category;
	private int upload_price;
	private String upload_content;
	private String upload_file_name;
	private String upload_file_loc;
	private Date upload_date;
	
	public UploadDto() {
		
	}

	public UploadDto(int upload_no, String upload_id, String upload_title, int upload_category, int upload_price, String upload_content,
			String upload_file_name, String upload_file_loc, Date upload_date) {
		this.upload_no = upload_no;
		this.upload_id = upload_id;
		this.upload_title = upload_title;
		this.upload_category = upload_category;
		this.upload_price = upload_price;
		this.upload_content = upload_content;
		this.upload_file_name = upload_file_name;
		this.upload_file_loc = upload_file_loc;
		this.upload_date = upload_date;
	}

	public int getUpload_no() {
		return upload_no;
	}

	public void setUpload_no(int upload_no) {
		this.upload_no = upload_no;
	}

	public String getUpload_id() {
		return upload_id;
	}

	public void setUpload_id(String upload_id) {
		this.upload_id = upload_id;
	}

	public String getUpload_title() {
		return upload_title;
	}

	public void setUpload_title(String upload_title) {
		this.upload_title = upload_title;
	}

	public int getUpload_category() {
		return upload_category;
	}

	public void setUpload_category(int upload_category) {
		this.upload_category = upload_category;
	}

	public int getUpload_price() {
		return upload_price;
	}

	public void setUpload_price(int upload_price) {
		this.upload_price = upload_price;
	}

	public String getUpload_content() {
		return upload_content;
	}

	public void setUpload_content(String upload_content) {
		this.upload_content = upload_content;
	}

	public String getUpload_file_name() {
		return upload_file_name;
	}

	public void setUpload_file_name(String upload_file_name) {
		this.upload_file_name = upload_file_name;
	}

	public String getUpload_file_loc() {
		return upload_file_loc;
	}

	public void setUpload_file_loc(String upload_file_loc) {
		this.upload_file_loc = upload_file_loc;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	
	
}
