<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beanDAO.*" import="connection.Conn" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- This page Adds Employee in a particular Department -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department</title>
</head>
<body background="images/pattern.jpg">


<font color="#FFF8DC">
<center><h1>DEPARTMENT DETAILS</h1><BR><BR><BR>
<PRE>
<%
int deptid=Integer.parseInt(request.getParameter("deptid"));
session.setAttribute("deptid", deptid);
DAO d=new DAO();
Bean b=new Bean();
Connection con=Conn.getConn();
String dept="";

b.setdeptid(deptid);

PreparedStatement ps1=con.prepareStatement("Select * from department where deptid=?");
ps1.setInt(1, deptid);
ResultSet rs2=ps1.executeQuery();
while(rs2.next())
	dept=rs2.getString(2);

b.setdept(dept);

PreparedStatement ps2=con.prepareStatement("Select * from employee where deptid=?");
ps2.setInt(1, deptid);
ResultSet rs=ps2.executeQuery();
%>
<center>Welcome To <%=dept %></center>
<br><br><br><br>
ID		NAME
<%
while(rs.next())
{
	if(rs.getString(7).equals("Employed"))
	{
%>
<%=rs.getInt(1) %>	<%=rs.getString(2) %><br><br>
<%} 
}%>
</PRE>
<a href ="TransferEmp.jsp" style="text-decoration:none" style="color:#FFF8DC">Transfer an Employee to a Different Department</a>
</center>
</font>


</body>
</html>