package com.alam.dto;

import java.util.Date;

public class ClassApplyDto {
	
	public int class_apply_no;
	public int class_apply_category;
	public String class_apply_id;
	public String class_apply_title;
	public String class_apply_content;
	public String class_apply_how;
	public String class_apply_loc;
	public Date class_apply_date;
	
	public ClassApplyDto() {
		
	}

	public ClassApplyDto(int class_apply_no, int class_apply_category, String class_apply_id, String class_apply_title,
			String class_apply_content, String class_apply_how, String class_apply_loc, Date class_apply_date) {
		this.class_apply_no = class_apply_no;
		this.class_apply_category = class_apply_category;
		this.class_apply_id = class_apply_id;
		this.class_apply_title = class_apply_title;
		this.class_apply_content = class_apply_content;
		this.class_apply_how = class_apply_how;
		this.class_apply_loc = class_apply_loc;
		this.class_apply_date = class_apply_date;
	}

	public int getClass_apply_no() {
		return class_apply_no;
	}

	public void setClass_apply_no(int class_apply_no) {
		this.class_apply_no = class_apply_no;
	}

	public int getClass_apply_category() {
		return class_apply_category;
	}

	public void setClass_apply_category(int class_apply_category) {
		this.class_apply_category = class_apply_category;
	}

	public String getClass_apply_id() {
		return class_apply_id;
	}

	public void setClass_apply_id(String class_apply_id) {
		this.class_apply_id = class_apply_id;
	}

	public String getClass_apply_title() {
		return class_apply_title;
	}

	public void setClass_apply_title(String class_apply_title) {
		this.class_apply_title = class_apply_title;
	}

	public String getClass_apply_content() {
		return class_apply_content;
	}

	public void setClass_apply_content(String class_apply_content) {
		this.class_apply_content = class_apply_content;
	}

	public String getClass_apply_how() {
		return class_apply_how;
	}

	public void setClass_apply_how(String class_apply_how) {
		this.class_apply_how = class_apply_how;
	}

	public String getClass_apply_loc() {
		return class_apply_loc;
	}

	public void setClass_apply_loc(String class_apply_loc) {
		this.class_apply_loc = class_apply_loc;
	}

	public Date getClass_apply_date() {
		return class_apply_date;
	}

	public void setClass_apply_date(Date class_apply_date) {
		this.class_apply_date = class_apply_date;
	}
		
}
