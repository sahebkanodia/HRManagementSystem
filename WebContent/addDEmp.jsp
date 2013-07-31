<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="connection.Conn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee In This Department</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<font color="#FFF8DC">
<center>
<%String dept=(String)session.getAttribute("dept");
int deptid=0;
Connection con=Conn.getConn();
PreparedStatement ps=con.prepareStatement("Select * from department where dept=?");
ps.setString(1,dept);
ResultSet rs=ps.executeQuery();
while(rs.next())
	deptid=rs.getInt(1);%>
Deptartment ID is : <%= deptid%>
<form action="table1.jsp">
<input type="submit" name="Submit" value="View Employee Table"></input>
</form>
<form method="get" action="AddDeptEmp">
ADD EMPLOYEE<br><br>
Employee ID <input type="text" name="id"></input>
<input type="submit" name="Submit" value="Add"></input>
</form>
</center>
</font>
</body>
</html>