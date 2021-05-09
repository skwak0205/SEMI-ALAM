package com.alam.biz;

import java.util.List;

import com.alam.dao.BoardDao;
import com.alam.dto.BoardDto;
import com.alam.dto.ReplyDto;
import com.alam.dto.SearchDto;

public class BoardBiz {
	private BoardDao dao = new BoardDao();
	
	public List<BoardDto> selectList(BoardDto dto){
		return dao.selectList(dto);
	}
	
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}
	
	public BoardDto detail(int board_no) {
		return dao.detail(board_no);
	}
	
	public int insertReply(ReplyDto dto) {
		return dao.insertReply(dto);
	}
	
	public List<ReplyDto> showReply() {
		return dao.showReply();
	}
	
	public String checkPW(BoardDto dto) {
		return dao.checkPW(dto);
	}
	
	public int boardUpdate(BoardDto dto) {
		return dao.boardUpdate(dto);
	}
	
	public int boardDelete(int board_no) {
		return dao.boardDelete(board_no);
	}
	
	public List<BoardDto> boardSearch(SearchDto dto) {
		return dao.boardSearch(dto);
	}
	
	public int viewCount(int board_no) {
		return dao.viewCount(board_no);
	}
	
	public int selectPagingCount(String category) {
		return dao.selectPagingCount(category);
	}
	
	public int selectSearchPagingcount(SearchDto dto) {
		return dao.selectSearchPagingcount(dto);
	}
	
}
