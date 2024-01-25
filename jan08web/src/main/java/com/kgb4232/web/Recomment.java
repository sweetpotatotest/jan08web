package com.kgb4232.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgb4232.dao.CommentDAO;
import com.kgb4232.dto.CommentDTO;
import com.kgb4232.util.Util;

@WebServlet("/recomment")
public class Recomment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Recomment() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int result = 0;
		if (session.getAttribute("mid") != null && Util.intCheck2(request.getParameter("cno"))
				&& request.getParameter("comment") != null) {

			CommentDTO dto = new CommentDTO();
			dto.setMid((String) session.getAttribute("mid"));
			dto.setCno(Util.str2Int2(request.getParameter("cno")));
			dto.setComment(request.getParameter("comment"));

			CommentDAO dao = new CommentDAO();
			result = dao.commentUpdate(dto);
		}
		PrintWriter pw = response.getWriter();
		pw.print(result);
	}

}