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
 * Servlet implementation class EditInfo
 */
public class EditInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		Bean b=new Bean();
		HttpSession session=req.getSession();
		int id=(Integer)session.getAttribute("id");
		b.setid(id);
		String name=req.getParameter("name");
		b.setname(name);
		String mob=req.getParameter("mobno");
		String addr=req.getParameter("addr");
		b.setaddr(addr);
		String email=req.getParameter("email");
		b.setemail(email);
		String sex=req.getParameter("sex");
		b.setsex(sex);
		String password=req.getParameter("password");
		b.setpassword(password);
		DAO d=new DAO();
		try {
			d.EditDetails(b,mob);
			res.sendRedirect("Success.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.sendRedirect("Failure.jsp");
		}
	}

}
