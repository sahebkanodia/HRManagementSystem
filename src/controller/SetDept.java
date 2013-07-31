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
 * Servlet implementation class SetDept
 */
public class SetDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		Bean b=new Bean();
		int deptid=Integer.parseInt(req.getParameter("deptid"));
		HttpSession session=req.getSession();
		int id=(Integer)session.getAttribute("id");
		b.setid(id);
		b.setdeptid(deptid);
		DAO d=new DAO();
		try {
			d.setD(b);
			res.sendRedirect("Success.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
