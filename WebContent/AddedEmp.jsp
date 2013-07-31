<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beanDAO.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Employee</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<center><font color="#FFF8DC">
<%		DAO d=new DAO();
		String name="", addr="", email="", sex="", password="", status="";
		int id=0,cl=0,pl=0,days=0,lstatus=0;
		long mobno=0;
	ResultSet rs=d.dispDetails(); 
	while(rs.next())
	{
		name=rs.getString(2);
		addr=rs.getString(3);
		email=rs.getString(4);
		sex=rs.getString(5);
		mobno=rs.getLong(8);
		id=rs.getInt(1);
		password=rs.getString(6);
		status=rs.getString(7);
		cl=rs.getInt(10);
		pl=rs.getInt(9);
		days=rs.getInt(11);
		lstatus=rs.getInt(12);
	}
	session.setAttribute("id",id);%>
<pre>The details of new employee are :<br><br><br><br>
ID : 		<%=id %><br><br>
Name :		<%=name %><br><br>
Mobile No.: <%=mobno %><br><br>
Email ID. : <%=email %><br><br>
Sex :		<%=sex %><br><br>
Address :	<%=addr %><br><br>
Password :	<%=password %><br><br>
Casual Leave :		<%=cl %><br><br>
Privileged Leave :	<%=pl %><br><br>
Leave Status : 	 <%=lstatus %><br><br>
Working Status : <%=status %><br><br>
</pre><p>
<form action="table5.jsp">
<input type="submit" name="Submit" value="View Department Table"></input>
</form></p>
<form method="get" action="SetDept">
Give Department ID : <input type="text" name="deptid"></input><br><br>
<input type="submit"  name="Submit" value="Save"></input>
</form>
</font></center>
</body>
</html>