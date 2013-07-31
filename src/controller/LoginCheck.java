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
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	res.setContentType("text/html");
	int id=Integer.parseInt(req.getParameter("id"));
	String password=req.getParameter("password");
	DAO d=new DAO();
	Bean b=new Bean();
	b.setid(id);
	b.setpassword(password);
	if(id==0 && password.equals("sulley"))
		res.sendRedirect("AdminPage.jsp");
	else
		try {
			if(d.checkDetails(b)==1)
			{	
				HttpSession session=req.getSession();
				session.setAttribute("id",id);
				res.sendRedirect("EmployeePage.jsp");
			}
			else
				res.sendRedirect("LoginFailure.jsp");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			res.sendRedirect("LoginFailure.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
