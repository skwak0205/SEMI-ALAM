package com.alam.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alam.dto.BoardDto;
import com.alam.dto.ReplyDto;
import com.alam.dto.SearchDto;

public class BoardDao extends SqlMapConfig {

	private String namespace = "board.mapper.";

	public List<BoardDto> selectList(BoardDto dto) {
		List<BoardDto> list = new ArrayList<BoardDto>();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace + "boardList", dto);
			session.close();
		}

		return list;
	}

	public int insert(BoardDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace + "boardInsert", dto);
		}

		return res;
	}

	public BoardDto detail(int board_no) {
		BoardDto dto = null;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			dto = session.selectOne(namespace + "boardDetail", board_no);
			session.close();
		}

		return dto;
	}

	public int insertReply(ReplyDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace + "reply", dto);
		}

		return res;
	}

	public List<ReplyDto> showReply() {
		List<ReplyDto> list = new ArrayList<ReplyDto>();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace + "showReply");
			session.close();
		}

		return list;
	}

	public String checkPW(BoardDto dto) {
		String pw = null;
		
		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			pw = session.selectOne(namespace + "readComplain", dto);
			session.close();
		}

		return pw;

	}

	public int boardUpdate(BoardDto dto) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.insert(namespace + "boardUpdate", dto);
		}

		return res;
	}

	public int boardDelete(int board_no) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.delete(namespace + "boardDelete", board_no);
		}

		return res;
	}

	public List<BoardDto> boardSearch(SearchDto dto) {
		List<BoardDto> list = new ArrayList<BoardDto>();

		try (SqlSession session = getSqlSessionFactory().openSession(false)) {
			list = session.selectList(namespace + "boardSearch", dto);
			session.close();
		}

		return list;
	}

	public int viewCount(int board_no) {
		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			res = session.update(namespace + "viewCount", board_no);
		}

		return res;
	}

	public int selectPagingCount(String category) {

		int countPage = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			countPage = session.selectOne(namespace + "selectpagingcount", category);
		}

		return countPage;
	}

	public int selectSearchPagingcount(SearchDto dto) {

		int countPage = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			countPage = session.selectOne(namespace + "selectSearchPagingcount", dto);
		}

		return countPage;
	}
}
