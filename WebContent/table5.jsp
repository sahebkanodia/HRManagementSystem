<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="beanDAO.Bean" %>
       <%@page import="beanDAO.DAO" %>
    <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<center><font color="#FFF8DC">
<center>DEPARTMENT DETAILS<BR><BR><BR>
</center>
<PRE>
<table border="0.25">

<tr><td>DEPARTMENT</td>		<td>DEPARTMENT ID</td></tr>
<%
DAO d=new DAO();
Bean b=new Bean();
ResultSet rs=d.tableD(); 
while(rs.next())
	if(rs.getInt(1)!=0)
{
%>
<tr><td><%=rs.getString(2) %></td>		<td><%=rs.getInt(1) %></td></tr>
<%} %>
</PRE><br><br></table>
</font></center>
</body>
</html>