package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanDAO.*;

/**
 * Servlet implementation class Approve
 */
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		DAO d=new DAO();
		Bean b=new Bean();
		b.setid(id);
		try {
			d.approve(b);
			res.sendRedirect("Success.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.sendRedirect("Failure.jsp");
		}
	}
}

