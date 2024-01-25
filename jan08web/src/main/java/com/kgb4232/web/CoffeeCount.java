package com.kgb4232.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgb4232.dao.CoffeeDAO;


@WebServlet("/coffeecount")
public class CoffeeCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CoffeeCount() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeDAO dao = new CoffeeDAO();
		int iceAmeCount = dao.coffeeCount("아아");
		int hotAmeCount = dao.coffeeCount("뜨아");
		int iceTeaCount = dao.coffeeCount("아차");
		int hotTeaCount = dao.coffeeCount("뜨차");
		
		request.setAttribute("iceAmeCount", iceAmeCount);
		request.setAttribute("hotAmeCount", hotAmeCount);
		request.setAttribute("iceTeaCount", iceTeaCount);
		request.setAttribute("hotTeaCount", hotTeaCount);
		
		RequestDispatcher rd = request.getRequestDispatcher("coffeecount.jsp"); //경로지정 값 보내기
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
