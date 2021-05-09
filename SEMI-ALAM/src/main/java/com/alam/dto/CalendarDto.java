package com.alam.dto;

import java.util.Date;

public class CalendarDto {
	private int calendar_no;
	private String calendar_id;
	private String calendar_title;
	private String calendar_start;
	private String calendar_end;
	private String calendar_allday;
	
	public CalendarDto() {
		
	}

	public CalendarDto(int calendar_no, String calendar_id, String calendar_title, String calendar_start,
			String calendar_end, String calendar_allday) {
		this.calendar_no = calendar_no;
		this.calendar_id = calendar_id;
		this.calendar_title = calendar_title;
		this.calendar_start = calendar_start;
		this.calendar_end = calendar_end;
		this.calendar_allday = calendar_allday;
	}

	public int getCalendar_no() {
		return calendar_no;
	}

	public void setCalendar_no(int calendar_no) {
		this.calendar_no = calendar_no;
	}

	public String getCalendar_id() {
		return calendar_id;
	}

	public void setCalendar_id(String calendar_id) {
		this.calendar_id = calendar_id;
	}

	public String getCalendar_title() {
		return calendar_title;
	}

	public void setCalendar_title(String calendar_title) {
		this.calendar_title = calendar_title;
	}

	public String getCalendar_start() {
		return calendar_start;
	}

	public void setCalendar_start(String calendar_start) {
		this.calendar_start = calendar_start;
	}

	public String getCalendar_end() {
		return calendar_end;
	}

	public void setCalendar_end(String calendar_end) {
		this.calendar_end = calendar_end;
	}

	public String getCalendar_allday() {
		return calendar_allday;
	}

	public void setCalendar_allday(String calendar_allday) {
		this.calendar_allday = calendar_allday;
	}
	
	
}
