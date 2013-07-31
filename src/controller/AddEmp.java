package controller;

import java.io.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanDAO.Bean;
import beanDAO.DAO;

/**
 * Servlet implementation class AddEmp
 */
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, FileNotFoundException{
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		Bean b=new Bean();
		String name=req.getParameter("name");
		b.setname(name);
		long mobno=Long.parseLong(req.getParameter("mobno"));
		b.setmobno(mobno);
		String addr=req.getParameter("addr");
		b.setaddr(addr);
		String email=req.getParameter("email");
		b.setemail(email);
		String sex=req.getParameter("sex");
		b.setsex(sex);
		DAO d=new DAO();
			try {
				d.addDetails(b);
				res.sendRedirect("AddedEmp.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//res.sendRedirect("Failure.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//res.sendRedirect("Failure.jsp");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//res.sendRedirect("Failure.jsp");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//res.sendRedirect("Failure.jsp");
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
