package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.CalendarDto;

public class CalendarDao extends SqlMapConfig {
	private String namespace = "calendar.mapper.";
	
	public int insertCalendar(CalendarDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace+"insertCalendar", dto);
		}
		
		return res;
	}
	
	public int deleteCalendar(CalendarDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace+"deleteCalendar", dto);
		}
		
		return res;
	}
	
	public List<CalendarDto> calendarList(CalendarDto dto) {
		List<CalendarDto> list = new ArrayList<CalendarDto>();
		
		try(SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace+"calendarList", dto);
			session.close();
		}
		
		return list;
	}
	
	public int updateCalendar(CalendarDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.update(namespace+"updateCalendar", dto);
		}
		
		return res;
	}
}
