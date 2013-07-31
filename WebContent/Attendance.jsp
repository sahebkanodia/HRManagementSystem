<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="beanDAO.*" %>
       <%@page import="connection.Conn" %>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance Details</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<center><font color="#FFF8DC">
<PRE>
<table border="0.25">

<tr>ATTENDANCE SHEET</tr>

<tr><td>ID</td>	<td>NAME</td>			<td>DEPARTMENT ID</td>	<td>CASUAL LEAVES</td>	<td>PRIVILIGED LEAVES</td></tr>
<%
DAO d=new DAO();
ResultSet rs=d.tableE(); 
while(rs.next())
{
	if(rs.getString(7).equals("Employed"))	
	{
%>
<tr><td><%=rs.getInt(1) %></td>	<td><%=rs.getString(2) %></td>			<td><%=rs.getInt(13) %></td>	<td><%=rs.getInt(10) %></td>	<td><%=rs.getInt(9) %></td></tr>
<%
	}
}
%></table>
</PRE>
<br><br>
LEAVE REQUESTS<br><br>
<PRE>
<table border="0.25">
<tr>ATTENDANCE APPROVAL SHEET</tr>
<tr><td>ID</td>		<td>NAME</td>			<td>DEPARTMENT ID</td>		<td>NO. OF DAYS</td></tr>
<%
DAO d2=new DAO();
ResultSet rs1=d2.tableE(); 
while(rs1.next())
{
	if(rs1.getString(7).equals("Employed") && rs1.getInt(12)==1)
	{	
	%>
<tr><td><%=rs1.getInt(1) %></td>		<td><%=rs1.getString(2) %></td>			<td><%=rs1.getInt(13) %></td>		<td><%=rs1.getInt(11) %></td></tr>
<%}} %></table>
</PRE>
<form action="Approve" method="get">
To approve leave, enter employee ID : <input type=text" name="id"></input>
<input type="submit" name="Submit" value="Approve"></input>
</form>
</font></center></body>
</html>