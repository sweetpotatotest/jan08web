package com.kgb4232.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgb4232.dao.CoffeeDAO;
import com.kgb4232.dto.CoffeeDTO;


@WebServlet("/coffee")
public class Coffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Coffee() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("mid") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("coffee.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("./login");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("coffee"));
		HttpSession session = request.getSession();
		
		CoffeeDTO dto = new CoffeeDTO();
		dto.setCfName(request.getParameter("coffee"));
		dto.setMid((String) session.getAttribute("mid"));
		
		CoffeeDAO dao = new CoffeeDAO();
		int result = dao.coffeeOrder(dto);
		if (result == 1) {
			response.sendRedirect("./coffeecount");
		} else {
			response.sendRedirect("./error.jsp");
		}
	}
}
