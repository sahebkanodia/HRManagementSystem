<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beanDAO.*" import="connection.Conn" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance sheet</title>
</head>
<body background="images/pattern.jpg"><br>
<center>
<img src="images/attendance-sheet.png">
</center>
<br><br><br>
<pre>
<font color="#FFF8DC" style="calibri">
	<%int id=(Integer)session.getAttribute("id");
DAO d=new DAO();
Connection con=Conn.getConn();
PreparedStatement ps=con.prepareStatement("Select * from employee where id=?");
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
%>
Your leave details :<br><br>
Casual leaves taken :<%=rs.getInt(10) %><br><br>
Privileged leaves taken : <%=rs.getInt(9) %><br><br>
Leave status : <%=rs.getInt(12)%><br><br>
No. of leaves requested : <%=rs.getInt(11)%><br><br>
<% } %>

</font></pre>
<br><br><center>
<a href="LeaveRequest.jsp"><img src="images/leave.png" border="0" style="border:none;max-width:100%;"></a>
</center>
</body>
</html>