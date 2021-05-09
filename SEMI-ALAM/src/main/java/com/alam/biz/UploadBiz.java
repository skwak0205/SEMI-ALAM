package com.alam.biz;

import java.util.List;

import com.alam.dao.UploadDao;
import com.alam.dto.UploadDto;

public class UploadBiz {
	private UploadDao dao = new UploadDao();
	
	public int upload(UploadDto dto) {
		return dao.upload(dto);
	}
	
	public List<UploadDto> uploadList(int category) {
		return dao.uploadList(category);
	}
	
	public int delete(UploadDto dto) {
		return dao.delete(dto);
	}
	
}
