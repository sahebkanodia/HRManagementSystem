<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="connection.Conn"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Your Info</title>
</head>
<body background="images/pattern.jpg"><br><br><br>
<%	Connection con=Conn.getConn();
	int id=(Integer)session.getAttribute("id");
	String name="", addr="", email="", sex="", password="";
	long mobno=0;
	PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{	
		name=rs.getString(2);
		addr=rs.getString(3);
		email=rs.getString(4);
		sex=rs.getString(5);
		mobno=rs.getLong(8);
		password=rs.getString(6);

	}	%>
<form method="get" action="EditInfo">
<font color="#C80000">*Put in your new information in the text fields. Empty boxes will leave your information unchanged.</font>
<center><font color="#FFF8DC"><br><br>
Name : <%=name %><input type="text" name="name"></input><br><br>
Mobile No. : <%=mobno %><input type="text" name="mobno"></input><br><br>
Address : <%=addr %><input type="text" name="addr"></input><br><br>
Email id : <%=email %><input type="text" name="email"></input><br><br>
Sex : <%=sex %><input type="text" name="sex"></input><br><br>
Password : <%=password %><input type="text" name="password"></input><br><br>
<input type="submit" value="Save" name="Submit"></input></font><br><br>
</center>
</form>
</body>
</html>