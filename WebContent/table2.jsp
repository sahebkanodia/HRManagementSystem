<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="beanDAO.*" %>
<%@page import="connection.Conn" %>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<center><font color="#FFF8DC">
<PRE>
<%
int id=(Integer)session.getAttribute("id");
DAO d=new DAO();
Bean b=new Bean();
Connection con=Conn.getConn();
b.setid(id);
int deptid=0;
String dept="";

PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
ps.setInt(1,id);
ResultSet rs1=ps.executeQuery();
while(rs1.next())
	deptid=Integer.parseInt(rs1.getString(13));

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
<table border="0.25">
<tr><td>ID</td>		<td>NAME</td></tr>
<%
while(rs.next())
{
	if(rs.getString(7).equals("Employed"))
	{
%>
<tr><td><%=rs.getInt(1) %></td>		<td><%=rs.getString(2) %></td></tr><br><br>
<%} 
}%>
</PRE>
</font></center></table>
</body>
</html>