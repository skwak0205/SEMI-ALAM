package com.alam.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alam.biz.BoardBiz;
import com.alam.dto.BoardDto;
import com.alam.dto.LoginDto;
import com.alam.dto.ReplyDto;
import com.alam.dto.SearchDto;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CHARSET = "utf-8";
	private static String ATTACHES_DIR = "";
	private static final int LIMIT_SIZE_BYTES = 1024 * 1024;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ATTACHES_DIR = request.getSession().getServletContext().getRealPath(""); 

		String command = request.getParameter("command");
		System.out.println("(" + command + ")");

		BoardBiz biz = new BoardBiz();
		HttpSession session = request.getSession();

		LoginDto user = (LoginDto) session.getAttribute("user");
		String userId = "";

		if (command == null) {
			command = "insertRes";
		}

		int currentPage = 1;
		int limit = 5;
		int startPage = 1;
		int endPage = 0;
		int prePage = 1;
		int nextPage = 1;

		if (command.equals("공지")) {
			String category = "공지";
			
			int maxPage = biz.selectPagingCount(category);
			BoardDto dto = new BoardDto();
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				
			}else {
				currentPage = 1;
			}
						
			if (currentPage > 1) {
				
				startPage = limit*currentPage-(limit-1);
				endPage = startPage + limit -1;
				
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
			} else {			
				startPage = ((int)((double)(currentPage)/limit + 0.9) -1) * limit + 1;
				endPage = startPage + limit -1;
				if(maxPage < endPage) {
					endPage = maxPage;
				}
			}
			maxPage = maxPage/limit+1;
			
			if(maxPage > 1 && currentPage == 1) {
				prePage = 1;
				nextPage = currentPage + 1;
			} else if (maxPage == 1) {
				prePage = 1;
				nextPage = 1;
			}
			
			dto.setBoard_category(category);
			dto.setStartPage(startPage);
			dto.setEndPage(endPage);
			
			List<BoardDto> list = biz.selectList(dto);			
			request.setAttribute("list", list);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("category", category);
			request.setAttribute("prePage", prePage);
			request.setAttribute("nextPage", nextPage);
			
			dispatch(request, response, "board/eventBoard.jsp");

		} else if (command.equals("문의")) {
			String category = "문의";
			int maxPage = biz.selectPagingCount(category);
						
			BoardDto dto = new BoardDto();
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}else {
				currentPage = 1;
			}
			
			
			if (currentPage > 1) {
				startPage = limit*currentPage-(limit-1);
				endPage = startPage + limit -1;
				
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
			} else {			
				startPage = ((int)((double)(currentPage)/limit + 0.9) -1) * limit + 1;
				endPage = startPage + limit -1;
				if(maxPage < endPage) {
					endPage = maxPage;
				}
			}
			maxPage = maxPage/limit+1;
			
			if(currentPage == 1) {
				prePage = 1;
				nextPage = currentPage + 1;
			}
			
			
			dto.setBoard_category(category);
			dto.setStartPage(startPage);
			dto.setEndPage(endPage);
			
			List<BoardDto> list = biz.selectList(dto);
			
			request.setAttribute("list", list);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("category", category);
			request.setAttribute("prePage", prePage);
			request.setAttribute("nextPage", nextPage);

			dispatch(request, response, "board/questionBoard.jsp");

		} else if (command.equals("신고")) {
			String category = "신고";
			int maxPage = biz.selectPagingCount(category);
			BoardDto dto = new BoardDto();
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}else {
				currentPage = 1;
			}
			
			
			if (currentPage > 1) {
				
				
				startPage = limit*currentPage-(limit-1);
				endPage = startPage + limit -1;
				
				
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
			} else {			
				startPage = ((int)((double)(currentPage)/limit + 0.9) -1) * limit + 1;
				endPage = startPage + limit -1;
				if(maxPage < endPage) {
					endPage = maxPage;
				}
			}
			maxPage = maxPage/limit+1;
			
			if(maxPage > 1 && currentPage == 1) {
				prePage = 1;
				nextPage = currentPage + 1;
			} else if (maxPage == 1) {
				prePage = 1;
				nextPage = 1;
			}
			
			dto.setBoard_category(category);
			dto.setStartPage(startPage);
			dto.setEndPage(endPage);
			
			List<BoardDto> list = biz.selectList(dto);			
			request.setAttribute("list", list);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("category", category);
			request.setAttribute("prePage", prePage);
			request.setAttribute("nextPage", nextPage);
			dispatch(request, response, "board/complainBoard.jsp");

		} else if (command.equals("checkPW")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			String id = request.getParameter("id");

			BoardDto dto = new BoardDto();
			dto.setBoard_no(board_no);
			dto.setBoard_main_id(id);

			String pw = biz.checkPW(dto);

			request.setAttribute("board_no", board_no);
			request.setAttribute("pw", pw);
			dispatch(request, response, "board/chkPW.jsp");

		} else if (command.equals("boardInsert")) {
			String category = request.getParameter("category");
			request.setAttribute("category", category);
			dispatch(request, response, "board/boardInsert.jsp");

		} else if (command.equals("insertRes")) {

			PrintWriter out = response.getWriter();

			String excuteType = "";

			int myseq = 0;
			String member_id = "";
			String title = "";
			String content = "";
			String category = "";
			String password = "";
			String myfileid = "";
			String myfileloc = "";

			try {
				File attachesDir = new File(ATTACHES_DIR);
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(attachesDir);
				fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

				List<FileItem> items = fileUpload.parseRequest(request);

				for (FileItem item : items) {
					if (item.isFormField()) {
						System.out.printf("파라미터 명 : %s, 파라미터 값 :  %s \n", item.getFieldName(), item.getString(CHARSET));

						if ("command".equals(item.getFieldName())) {
							excuteType = item.getString(CHARSET);
						}

						if ("board_no".equals(item.getFieldName())) {
							myseq = Integer.parseInt(item.getString(CHARSET));
						}

						if ("member_id".equals(item.getFieldName())) {
							member_id = item.getString(CHARSET);
						}

						if ("title".equals(item.getFieldName())) {
							title = item.getString(CHARSET);
						}

						if ("content".equals(item.getFieldName())) {
							content = item.getString(CHARSET);
						}

						if ("category".equals(item.getFieldName())) {
							category = item.getString(CHARSET);
						}

						if ("password".equals(item.getFieldName())) {
							password = item.getString(CHARSET);
						}

						if ("file".equals(item.getFieldName())) {
							myfileid = item.getString(CHARSET);
						}

					} else {
						System.out.printf("파라미터 명 : %s, 파일 명 : %s,  파일 크기 : %s bytes \n", item.getFieldName(),
								item.getName(), item.getSize());
						if (item.getSize() > 0) {
							if ("file".equals(item.getFieldName())) {
								String separator = File.separator;
								int index = item.getName().lastIndexOf(separator);
								String fileName = item.getName().substring(index + 1);
								File uploadFile = new File(ATTACHES_DIR + fileName);
								item.write(uploadFile);

								myfileid = item.getName();

							}
						}
					}
				}

				if ("insertRes".equals(excuteType)) {

					content = content.replace("<p>", "");
					content = content.replace("</p>", "");

					BoardDto dto = new BoardDto(0, category, member_id, title, content, null, password, myfileid,
							myfileloc);
					int res = biz.insert(dto);

					if (res > 0) {
						jsResponse(response, "글작성 성공", "board.do?command=" + category);
					} else {
						jsResponse(response, "글작성 실패", "board.do?command=boardInsert&category=" + category);
					}
				} else if ("updateRes".equals(excuteType)) {

					BoardDto dto = new BoardDto(myseq, category, member_id, title, content, null, password, myfileid,
							myfileloc);
					int res = biz.boardUpdate(dto);

					if (res > 0) {
						jsResponse(response, "수정 성공", "board.do?command=detail&board_no=" + myseq);
					} else {
						jsResponse(response, "수정 실패", "board.do?command=boardUpdate&board_no=" + myseq);
					}
				}

			} catch (Exception e) {
				// 파일 업로드 처리 중 오류가 발생하는 경우
				e.printStackTrace();
				out.println("<h1>파일 업로드 중 오류가  발생하였습니다.</h1>");
			}

		} else if (command.equals("detail")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			int result = getViewCount(request, response, board_no);

			BoardDto dto = biz.detail(board_no);

			List<ReplyDto> replyList = biz.showReply();

			request.setAttribute("dto", dto);
			request.setAttribute("replyList", replyList);
			dispatch(request, response, "board/boardDetail.jsp");

		} else if (command.equals("reply")) {
			if (user == null) {
				dispatch(request, response, "member_login.jsp");
			} else {
				userId = user.getMember_id();

				int board_no = Integer.parseInt(request.getParameter("board_no"));
				String board_category = request.getParameter("board_category");
				String reply_content = request.getParameter("replyContent");

				ReplyDto dto = new ReplyDto(0, board_no, board_category, userId, reply_content, null);
				int res = biz.insertReply(dto);
				if (res > 0) {
					jsResponse(response, "답변 성공", "board.do?command=detail&board_no=" + board_no);
				} else {
					jsResponse(response, "답변 실패", "board.do?command=detail&board_no=" + board_no);
				}
			}
		} else if (command.equals("boardUpdate")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			BoardDto dto = biz.detail(board_no);

			request.setAttribute("dto", dto);
			dispatch(request, response, "board/boardUpdate.jsp");

		} else if (command.equals("updateRes")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardDto dto = new BoardDto();
			dto.setBoard_no(board_no);
			dto.setBoard_main_title(title);
			dto.setBoard_main_content(content);

			int res = biz.boardUpdate(dto);
			if (res > 0) {
				jsResponse(response, "수정 성공", "board.do?command=detail&board_no=" + board_no);
			} else {
				jsResponse(response, "수정 실패", "board.do?command=boardUpdate&board_no=" + board_no);
			}

		} else if (command.equals("boardDelete")) {
			String category = request.getParameter("category");
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			int res = biz.boardDelete(board_no);
			if (res > 0) {
				jsResponse(response, "삭제 성공", "board.do?command=" + category);
			} else {
				jsResponse(response, "삭제 실패", "board.do?command=detail&board_no=" + board_no);
			}

		} else if (command.equals("boardSearch")) {
			String category = request.getParameter("category");
			String searchChoice = request.getParameter("searchChoice");
			String searchInput = request.getParameter("searchInput");
							
			SearchDto dto2 = new SearchDto();
			dto2.setCategory(category);
			dto2.setSearchChoice(searchChoice);
			dto2.setSearchInput(searchInput);
		
			
			int maxPage = biz.selectSearchPagingcount(dto2);
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}else {
				currentPage = 1;
			}
			
			
			if (currentPage > 1) {
				startPage = limit*currentPage-(limit-1);
				endPage = startPage + limit -1;
				
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
			} else {			
				startPage = ((int)((double)(currentPage)/limit + 0.9) -1) * limit + 1;
				endPage = startPage + limit -1;
				if(maxPage < endPage) {
					endPage = maxPage;
				}
			}
			maxPage = maxPage/limit+1;
			
			if(maxPage > 1 && currentPage == 1) {
				prePage = 1;
				nextPage = currentPage + 1;
			} else if (maxPage == 1) {
				prePage = 1;
				nextPage = 1;
			}
							
			dto2.setStartPage(startPage);
			dto2.setEndPage(endPage);
			
			List<BoardDto> list = biz.boardSearch(dto2);
			
			request.setAttribute("list", list);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("category", category);
			request.setAttribute("prePage", prePage);
			request.setAttribute("nextPage", nextPage);
			request.setAttribute("searchYn", "y");
			request.setAttribute("searchChoice", searchChoice);
			request.setAttribute("searchInput", searchInput);
			dispatch(request, response, "board/questionBoard.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url
				+ "';" + "</script>";

		response.getWriter().print(responseText);
	}

	private int getViewCount(HttpServletRequest request, HttpServletResponse response, int board_no) {
		Cookie[] cookies = request.getCookies();
		int result = 0;
		BoardBiz biz = new BoardBiz();
		String no = String.valueOf(board_no);

		boolean isGet = false;
		if (cookies != null) {
			for (Cookie cookie : cookies) {//
				if (cookie.getName().equals("visit")) {
					isGet = true;

					if (!cookie.getValue().contains(no)) {
						cookie.setValue(cookie.getValue() + "_" + no);
						response.addCookie(cookie);
						result = biz.viewCount(board_no);
					}
				}
			}
			if (!isGet) {
				result = biz.viewCount(board_no);// 조회수증가
				Cookie c1 = new Cookie("visit", no);
				c1.setMaxAge(1 * 24 * 60 * 60);// 하루저장
				response.addCookie(c1);
			}
		}

		return result;
	}

}
