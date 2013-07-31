<%@ page language="java" %>
<%@page import="beanDAO.Bean"%>
<%@page import="beanDAO.DAO"%>
<%@page import="java.sql.ResultSet"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Table</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<center><font color="#FFF8DC">
<PRE>

<table border="0.25">
<tr>EMPLOYEE DETAILS :</tr>


<tr><td>ID</td>	 <td>NAME</td>			 <td>MOBILE NO.</td> 	<td>SEX</td> 	<td>EMAIL-ID</td> 		<td>ADDRESS</td>				 <td>DEPARTMENT-ID</td></tr>

<%
DAO d=new DAO();
ResultSet rs=d.tableE(); 
while(rs.next())
{
if((rs.getString(7)).equals("Employed"))
{%>
<tr><td><%=rs.getInt(1) %></td>	 <td><%=rs.getString(2) %></td>			 <td><%=rs.getLong(8) %></td> 	<td><%=rs.getString(5) %></td> 	<td><%=rs.getString(4) %></td> 		<td><%=rs.getString(3) %></td>				 <td><%=rs.getString(13) %></td></tr><br><br>
<%}
}%></table>	</PRE>
</font></center>
</body>
</html>