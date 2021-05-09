package com.alam.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alam.biz.PaymentBiz;
import com.alam.biz.UploadBiz;
import com.alam.dto.LoginDto;
import com.alam.dto.PaymentDto;
import com.alam.dto.UploadDto;

@WebServlet("/online.do")
public class OnlineClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CHARSET = "utf-8";
	private static String ATTACHES_DIR = "";
	private static final int LIMIT_SIZE_BYTES = 1024 * 1024;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ATTACHES_DIR = request.getSession().getServletContext().getRealPath(""); 
		
		HttpSession session = request.getSession();
		LoginDto user = (LoginDto) session.getAttribute("user");
		String userId = "";
		UploadBiz biz = new UploadBiz();
		PaymentBiz paymentBiz = new PaymentBiz();

		String command = request.getParameter("command");
		System.out.println("--"+command+"--");
		
		if (command == null) {
			command = "uploadRes";
		
		} else if (command.equals("온라인")) {
			dispatch(request, response, "onlineClass/onlineClassBoard.jsp");
		} 
		
		switch(command) {
			case "it":
				path(request, response, biz, paymentBiz, user, 1);
				dispatch(request, response, "onlineClass/onlineClassIt.jsp");
				break;
				
			case "school":
				path(request, response, biz, paymentBiz, user, 2);
				dispatch(request, response, "onlineClass/onlineClassSchool.jsp");
				break;
				
			case "beauty":
				path(request, response, biz, paymentBiz, user, 3);
				dispatch(request, response, "onlineClass/onlineClassBeauty.jsp");
				break;
				
			case "language":
				path(request, response, biz, paymentBiz, user, 4);
				dispatch(request, response, "onlineClass/onlineClassLanguage.jsp");
				break;
				
			case "cook":
				path(request, response, biz, paymentBiz, user, 5);
				dispatch(request, response, "onlineClass/onlineClassCook.jsp");
				break;
				
			case "license":
				path(request, response, biz, paymentBiz, user, 6);
				dispatch(request, response, "onlineClass/onlineClassLicense.jsp");
				break;
			
			case "etc":
				path(request, response, biz, paymentBiz, user, 7);
				dispatch(request, response, "onlineClass/onlineClassEtc.jsp");
				break;
		}

		
		if (command.equals("upload")) {
			if(user == null) {
				dispatch(request, response, "member_login.jsp");
			} else {
				dispatch(request, response, "onlineClass/onlineClassUpload.jsp");
			}
		} else if (command.equals("uploadRes")) {
			
			PrintWriter out = response.getWriter();

			String excuteType = "";

			int upload_seq = 0;
			String member_id = "";
			String title = "";
			String content = "";
			int category = 0;
			int price = 0;
			String upload_filename = "";
			String upload_fileloc = "";

			try {
				File attachesDir = new File(ATTACHES_DIR);
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(attachesDir);
				fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

				List<FileItem> items = fileUpload.parseRequest(request);
				
				System.out.println("itmes : " + items);

				for (FileItem item : items) {
					if (item.isFormField()) {
						System.out.printf("파라미터 명 : %s, 파라미터 값 :  %s \n", item.getFieldName(), item.getString(CHARSET));

						if ("command".equals(item.getFieldName())) {
							excuteType = item.getString(CHARSET);
						}

						if ("board_no".equals(item.getFieldName())) {
							upload_seq = Integer.parseInt(item.getString(CHARSET));
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
							category = Integer.parseInt(item.getString(CHARSET));
						}

						if ("price".equals(item.getFieldName())) {
							price = Integer.parseInt(item.getString(CHARSET));
						}

						if ("file".equals(item.getFieldName())) {
							upload_filename = item.getString(CHARSET);
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

								upload_filename = item.getName();

							}
						}
					}
				}

				if ("uploadRes".equals(excuteType)) {

					content = content.replace("<p>", "");
					content = content.replace("</p>", "");
					
					System.out.println("category : " + category);

					UploadDto dto = new UploadDto(upload_seq, member_id, title, category, price, content, upload_filename, upload_fileloc, null);
					int res = biz.upload(dto);
					
					String c = getCategory(category);
					
					if(res > 0) {
						jsResponse(response, "업로드 성공", "online.do?command="+c);
					} else {
						jsResponse(response, "업로드 실패", "online.do?command=upload");
					}
				} 

			} catch (Exception e) {
				// 파일 업로드 처리 중 오류가 발생하는 경우
				e.printStackTrace();
				out.println("<h1>파일 업로드 중 오류가  발생하였습니다.</h1>");
			}
		} else if (command.equals("paid")) {
			
			userId = user.getMember_id();			
			List<PaymentDto> payList = paymentBiz.paidList(userId);
			request.setAttribute("list", payList);
			
			dispatch(request, response, "onlineClass/onlineClassPaid.jsp");
		
		} else if (command.equals("delete")) {
			if(user == null) {
				dispatch(request, response, "member_login.jsp");
			}
			userId = user.getMember_id();
			int upload_no = Integer.parseInt(request.getParameter("upload_no"));
			
			UploadDto dto = new UploadDto();
			dto.setUpload_no(upload_no);
			dto.setUpload_id(userId);
			
			int res = biz.delete(dto);
			if(res > 0) {
				jsResponse(response, "삭제 성공", "classApply.do?command=온라인");
			} else {
				jsResponse(response, "삭제 실패", "classApply.do?command=온라인");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url
				+ "';" + "</script>";

		response.getWriter().print(responseText);
	}
	
    private String getCategory(int c) {
    	switch(c) {
    	case 1:
    		return "it";
    	case 2:
    		return "school";
    	case 3:
    		return "beauty";
    	case 4:
    		return "language";
    	case 5:
    		return "cook";
    	case 6:
    		return "license";
    	case 7:
    		return "etc";
    	default:
    		return "it";
    	}
    }
    
    private void path(HttpServletRequest request, HttpServletResponse response, UploadBiz uploadBiz, PaymentBiz paymentBiz, LoginDto user, int c) {
    	List<UploadDto> list = uploadBiz.uploadList(c);
		request.setAttribute("list", list);
		
    }

}
