package com.alam.dto;

import java.util.Date;

public class ApplyMentorDto {
	private int apply_no;
	private int apply_category;
	private String apply_id;
	private int apply_price;
	private String apply_content;
	private String apply_how;
	private Date apply_date;
	
	public ApplyMentorDto() {
		
	}

	public ApplyMentorDto(int apply_no, int apply_category, String apply_id, int apply_price, String apply_content,
			String apply_how, Date apply_date) {
		this.apply_no = apply_no;
		this.apply_category = apply_category;
		this.apply_id = apply_id;
		this.apply_price = apply_price;
		this.apply_content = apply_content;
		this.apply_how = apply_how;
		this.apply_date = apply_date;
	}

	public int getApply_no() {
		return apply_no;
	}

	public void setApply_no(int apply_no) {
		this.apply_no = apply_no;
	}

	public int getApply_category() {
		return apply_category;
	}

	public void setApply_category(int apply_category) {
		this.apply_category = apply_category;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public int getApply_price() {
		return apply_price;
	}

	public void setApply_price(int apply_price) {
		this.apply_price = apply_price;
	}

	public String getApply_content() {
		return apply_content;
	}

	public void setApply_content(String apply_content) {
		this.apply_content = apply_content;
	}

	public String getApply_how() {
		return apply_how;
	}

	public void setApply_how(String apply_how) {
		this.apply_how = apply_how;
	}

	public Date getApply_date() {
		return apply_date;
	}

	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}
	
	
}
