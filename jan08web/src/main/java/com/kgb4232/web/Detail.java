package com.kgb4232.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgb4232.dao.BoardDAO;
import com.kgb4232.dao.LogDAO;
import com.kgb4232.dto.BoardDTO;
import com.kgb4232.dto.CommentDTO;
import com.kgb4232.util.Util;


@WebServlet("/detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Detail() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//오는 번호 잡기
//		int no = Integer.parseInt(request.getParameter("no"));
		int no = Util.str2Int(request.getParameter("no"));
		
		//log
		LogDAO log = new LogDAO();
		log.write(Util.getIP(request), "./detail", "no="+no);
		
		
		
		//데이터베이스에 질의하기
		BoardDAO dao = new BoardDAO();
		
		//읽음수 올리기 2024-01-19
		//로그인한 회원이라면
		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null) {
			//bno = no, mno =?
			dao.countUp(no, (String) session.getAttribute("mid"));
		}
		
		
		BoardDTO dto = dao.detail(no);
		
//		StringBuilder sb = new StringBuilder(dto.getIp());
//		dto.setIp(sb.replace(4, 6, "※").toString());
		
		
		//System.out.println(dto.getTitle());
		//System.out.println(dto.getContent() == null);
		if (no == 0 || dto.getContent() == null) {
			//null이면 아래로
			response.sendRedirect("./error.jsp");
			System.out.println("detail문제입니다.");
		} else {
			//정상 출력
			//내용 가져오기
			request.setAttribute("detail", dto);
			
			//댓글이 있다면 List뽑아내기
			List<CommentDTO> commentList = dao.commentList(no);
			
			if (commentList.size() > 0) {
				request.setAttribute("commentList", commentList);
			}
			
			
			//리퀘스트디스패쳐 호출하기
			RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
			rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
