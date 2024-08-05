package com.koreaIT.java.jsp_AM;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/printDan")

public class PrintDanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charest=UTF-8");
		String inputedDan = request.getParameter("dan");
		String inputedLimit = request.getParameter("limit");
		String inputcolor = request.getParameter("color");
		if (inputedDan == null) {
			inputedDan = "1";
		}

		if (inputedLimit == null) {
			inputedLimit = "9";
		}

		int dan = Integer.parseInt(inputedDan);
		int limit = Integer.parseInt(inputedLimit);
		
		response.getWriter().append("<font color = " + inputcolor + ">");
		response.getWriter().append("==" + dan + "단==<br>");
		
		
		for (int i = 1; i <=limit; i++) {
			response.getWriter().append(String.format("%d * %d = %d<br>", dan, i , dan * i));
		}
		
	}
}
