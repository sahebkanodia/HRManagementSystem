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
 * Servlet implementation class Leave
 */
public class Leave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		int days=Integer.parseInt(req.getParameter("days"));
		HttpSession session=req.getSession();
		int id=(Integer)session.getAttribute("id");
		DAO d=new DAO();
		Bean b=new Bean();
		b.setid(id);
		b.setdays(days);
		try {
			if(d.leaveCheck(b)==1)
				res.sendRedirect("Requestsent.jsp");
			else
				res.sendRedirect("NoLeavesLeft.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.sendRedirect("Failure.jsp");
		}
		
	}

}
