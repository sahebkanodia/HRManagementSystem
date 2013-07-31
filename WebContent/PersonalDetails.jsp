<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beanDAO.*" import="connection.Conn" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Details</title>
</head>
<body background="images/pattern.jpg">
<%	Connection con=Conn.getConn();
	int id=(Integer)session.getAttribute("id");
	PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
	 %>
<center ><font color="#FFF8DC"><h1>WELCOME TO YOUR ACCOUNT</h1><br><br>
Name : <%=rs.getString(2) %><br><br>
Mobile No. : <%=rs.getLong(8) %><br><br>
Address : <%=rs.getString(3) %><br><br>
Email id : <%=rs.getString(4) %><br><br>
Sex : <%=rs.getString(5) %><br><br>
Username : <%=id %><br><br>
Password : <%=rs.getString(6) %><br><br>
Department ID : <%=rs.getInt(13) %><br><br>
Working Status : <%=rs.getString(7) %><br><br>
<%} %>

<a href="EditInfo.jsp" style="text-decoration=none" style="color:#FFF8DC">Edit your personal information</a>
</font>
</center>
</body>
</html>