package com.alam.biz;

import java.util.List;

import com.alam.dao.CalendarDao;
import com.alam.dto.CalendarDto;

public class CalendarBiz {
	private CalendarDao dao = new CalendarDao();
	
	public int insertCalendar(CalendarDto dto) {
		return dao.insertCalendar(dto);
	}
	
	public int deleteCalendar(CalendarDto dto) {
		return dao.deleteCalendar(dto);
	}
	
	public List<CalendarDto> calendarList(CalendarDto dto) {
		return dao.calendarList(dto);
	}
	
	public int updateCalendar(CalendarDto dto) {
		return dao.updateCalendar(dto);
	}
}
