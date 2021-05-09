package com.alam.biz;

import java.util.List;

import com.alam.dao.ClassApplyDao;
import com.alam.dto.BoardDto;
import com.alam.dto.ClassApplyDto;

public class ClassApplyBiz {
	
	private ClassApplyDao dao = new ClassApplyDao();
	
	public List<ClassApplyDto> selectList(int category){
		return dao.selectList(category);
	}
	
	public int classInsert(ClassApplyDto dto) {
		return dao.classInsert(dto);
	}
	
	public ClassApplyDto classDetail(int class_apply_no){
		return dao.classDetail(class_apply_no);
	}
	
	public int classUpdate(ClassApplyDto dto) {
		return dao.classUpdate(dto);
	}
	
	public int classDelete(int class_apply_no) {
		return dao.classDelete(class_apply_no);
	}
	
}


