package com.kgb4232.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgb4232.dao.BoardDAO;
import com.kgb4232.dto.BoardDTO;
import com.kgb4232.util.Util;


@WebServlet("/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Write() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("mname") == null) {
			response.sendRedirect("./login"); //url까지 변경후 화면 보여줌(/login으로 변경됨 전의 /write가 없어짐)
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("write.jsp"); //url고정, 화면만 변경
			rd.forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8"); // 한글처리
		
		//세션에 들어있는 mid가져오기
		HttpSession session = request.getSession();
		//if문으로 로그인 되어있는(=세션이 있는) 사람만이 접속 할수 있게끔
		if (session.getAttribute("mid") == null || session.getAttribute("mname") == null) {
			//로그인 하지 않았다면 login.jsp로 가게 하겠습니다.
			response.sendRedirect("./login?login=nologin");
		} else {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			
//			//오는 값에서 특수기호 <,>, 변경하기
//			content = Util.removeTag(content);
//			
//			// 엔터처리해주기 /n /r /nr =>엔터로 변경
//			content = Util.addBR(content);
//			
			
			//DAO에 write메소드 만들기
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setMid((String) session.getAttribute("mid")); //세션에서 mid 가져옵니다.
			dto.setIp(Util.getIP(request));
			
			BoardDAO dao = new BoardDAO();
			int result = dao.write(dto);
			System.out.println("글쓰기 결과는 : " + result);
			
			//페이지 이동하기 = url값과 화면 모두 이동하기
			if (result == 1) {
				response.sendRedirect("./board");
			} else {
				response.sendRedirect("./error.jsp");
			}
		}
		
	}

}
