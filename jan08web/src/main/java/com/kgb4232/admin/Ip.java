package com.kgb4232.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgb4232.dao.AdminDAO;


@WebServlet("/admin/ip") //url의 경로 = 실제 파일과 다르게 호출할 url을 지정합니다.
public class Ip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ip() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getAttribute("ip"));
		
		AdminDAO dao = new AdminDAO();
		
//		List<Map<String, Object>> list1 = null; // 맵을 사용하면 이후에 뒤에서 dao에 dto설정을 안해도됨!
//		list1 = dao.ipList();
		
//		List<Map<String, Object>> list2 = new ArrayList<>();
//		list2 = dao.mostConnectedIP5();
		request.setAttribute("list2", dao.mostConnectedIP5()); //한번에 생성하고 보내준다.

		
		
		List<Map<String, Object>> list1 = null; //기본 보드 a태그 눌렀을때 오류 수정
		if (request.getParameter("ip") != null && !request.getParameter("ip").equals("")) {
			list1 = dao.ipList(request.getParameter("ip"));
		} else {
			list1 = dao.ipList();
		}
		request.setAttribute("list1", list1);
		
		
		
		
//		List<Map<String, Object>> list3 = new ArrayList<>();
//		list3 = dao.lastestIP5();
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/ip.jsp");//파일 있는 경로
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		
	}

}