package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanDAO.Bean;
import beanDAO.DAO;

/**
 * Servlet implementation class AddDept
 */
public class AddDept extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//res.setContentType("text/html");
		String dept=req.getParameter("dept");
		Bean b=new Bean();
		b.setdept(dept);
		DAO d=new DAO();
		HttpSession session=req.getSession();
		session.setAttribute("dept", dept);
		try {
			d.addDpt(b);
			res.sendRedirect("addDEmp.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.sendRedirect("Failure.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
