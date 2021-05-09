package com.alam.biz;

import java.util.List;

import com.alam.dao.AdminDao;
import com.alam.dao.BoardDao;
import com.alam.dto.ApplyMentorDto;
import com.alam.dto.BoardDto;
import com.alam.dto.LoginDto;

public class AdminBiz {

	BoardDao boarddao = new BoardDao();
	AdminDao admindao = new AdminDao();
	
	public List<BoardDto> searchList(String query){
		return admindao.searchList(query);
	}
	
	public LoginDto searchId(String query) {
		return admindao.searchId(query);
	}
	
	public List<LoginDto> memberListAll(){
		return admindao.memberListAll();
	}
	
	public int adminDelMember(String member_id) {
		return admindao.adminDelMember(member_id);
	}
	
	public List<BoardDto> adminComplaint(){
		return admindao.adminComplaint();
	}
	
	public List<BoardDto> adminAsk(){
		return admindao.adminAsk();
	}
	
	public List<ApplyMentorDto> apply_list(){
		return admindao.apply_list();
	}
}
