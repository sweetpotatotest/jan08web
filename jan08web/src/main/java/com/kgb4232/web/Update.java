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

@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
    }

    //no 잡기
//		int no = Util.str2Int(request.getParameter("no"));
//		//DAO에게 질의하기
//		BoardDAO dao = new BoardDAO();
//		BoardDTO dto = dao.detail(no); //update랑 detail이랑 결론적으론 같음..
//		//jps에 보내기
//		request.setAttribute("update", dto);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
//		rd.forward(request, response);//내용까지 바꿈 + 위치이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터를 화면에 띄우기
		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null) {
			//세션이 있을 때 = 정상작업하기
			int no = Util.str2Int(request.getParameter("no"));
			//DAO에게 일시키기
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = dao.detail(no);
//			System.out.println(dto.getMid().equals(session.getAttribute("mid"))); //t
//			System.out.println(session.getAttribute("mid").equals(dto.getMid())); //t
//			System.out.println(session.getAttribute("mid") == dto.getMid()); //f ->equals로 값비교 해야됨 스트링..
//			System.out.println(((String)session.getAttribute("mid")).equals(dto.getMid())); //t
			
			if (dto.getMid().equals(session.getAttribute("mid"))) {
				request.setAttribute("update", dto);
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("./error.jsp");
			}
			
		} else {
			response.sendRedirect("./login?login=nologin");
		}
		
		
		
		
		
		
//		if (Util.intCheck(request.getParameter("no"))) {
//			//숫자0 > 삭제 진행 -> board로 이동
//			// 번호 잡기 
//			if (no == 0 || dto.getContent() == null) {
//				//null이면 아래로
//				response.sendRedirect("./error.jsp");
//			} else {
//				//정상 출력
//				//내용 가져오기
//				request.setAttribute("update", dto);
				////리퀘스트디스패쳐 호출하기
//			}
//		else {
//			//숫자X > 에러 표시
//			System.out.println("문자입니다.");
//			response.sendRedirect("./error.jsp");
//		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//실제 db저장
		HttpSession session = request.getSession();
		if (request.getParameter("title") != null && request.getParameter("content") != null 
				&& Util.intCheck(request.getParameter("no")) && session.getAttribute("mid") != null) {
			//진짜 수정 : 자기 위치로
			BoardDTO dto = new BoardDTO();
			dto.setContent(request.getParameter("content"));
			dto.setTitle(request.getParameter("title"));
			dto.setNo(Util.str2Int(request.getParameter("no")));
			dto.setMid((String) session.getAttribute("mid"));
			
			BoardDAO dao = new BoardDAO();
			int result = dao.update(dto);
			System.out.println("수정 결과: " + result);
			
			response.sendRedirect("./detail?no=" + request.getParameter("no"));
		} else {
			//error
			response.sendRedirect("./error.jsp");
		}
	}

}
