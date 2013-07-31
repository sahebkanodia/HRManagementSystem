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
 * Servlet implementation class AddDeptEmp
 */
public class AddDeptEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//res.setContentType("text/html");
		Bean b=new Bean();
		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		String dept=(String)session.getAttribute("dept");
		b.setid(id);
		b.setdept(dept);
		DAO d=new DAO();
		try {
			d.addDemp(b);
			res.sendRedirect("addDEmp.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.sendRedirect("Failure.jsp");
		}
		
		
	}

}
