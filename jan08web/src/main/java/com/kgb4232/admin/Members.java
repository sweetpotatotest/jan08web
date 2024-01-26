package com.kgb4232.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgb4232.dao.AdminDAO;
import com.kgb4232.dao.MemberDAO;
import com.kgb4232.dto.MemberDTO;
import com.kgb4232.util.Util;


@WebServlet("/admin/members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Members() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> list = dao.memberList();
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/members.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("mno"));
		System.out.println(request.getParameter("grade"));
		
		//db에 변경
		MemberDTO dto = new MemberDTO();
		dto.setMno(Util.str2Int(request.getParameter("mno")));
		dto.setMgrade(Util.str2Int(request.getParameter("grade")));
		
		MemberDAO dao = new MemberDAO();
		int result = dao.gradeChange(dto);
		if (result == 1) {
			//페이지 이동
			response.sendRedirect("./members");
		} else {
			response.sendRedirect("./error.jsp");
		}
		
	}

}
