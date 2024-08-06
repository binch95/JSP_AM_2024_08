package com.koreaIT.java.jsp_AM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/article/list")
public class ArticlelistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charest=UTF-8");
		
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		response.getWriter().append("123");
		
		String url = "jdbc:mysql://localhost:3306/Article";
		String user = "root";
		String password = "";
		
		 Connection conn = null;		
        try {
          conn = DriverManager.getConnection(url, "root", "");
          response.getWriter().append("연결성공!");
          
          DBUtil dbUtil = new DBUtil(request, response); 
          
          String sql = "SELECT * FROM article ORDER BY id DESC";
          
          List<Map<String, Object>> articleRows = dbUtil.selectRows(conn, sql);
          
//          response.getWriter().append(articleRows.toString());
                  
          request.setAttribute("articleRows", articleRows);
          request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);


        } catch (SQLException e) {
            System.out.println("에러 1 : " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		
	}

}
