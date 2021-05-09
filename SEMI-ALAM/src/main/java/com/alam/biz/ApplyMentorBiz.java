package com.alam.biz;

import com.alam.dao.ApplyMentorDao;
import com.alam.dto.ApplyMentorDto;

public class ApplyMentorBiz {
	private ApplyMentorDao dao = new ApplyMentorDao();
	
	public int insert(ApplyMentorDto dto) {
		return dao.insert(dto);
	}
	
	public int deleteApproved(String mentorId) {
		return dao.deleteApproved(mentorId);
	}
}
