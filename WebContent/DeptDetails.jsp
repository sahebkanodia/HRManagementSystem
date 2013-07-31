<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Details</title>
</head>
<body background="images/pattern.jpg"><br>
<center><h1><font color="FFF8DC">Departments</font></h1>
<br><br><br>
<!-- This Page displays all the Departments in the Database. -->
<form action="table5.jsp" method="post">
<input type="submit" name="Submit" value="View Departments"></input>
</form>
<font color="#FFF8DC" >
<form action="ParticularDept.jsp" method="GET">
*To view a particular department give department id<br><br>
Deartment ID : <input type="text" name="deptid"></input><br><br>

<input type="submit" value="View" name="Submit"></input>
<br><br>
<a href="addDept.jsp" style="text-decoration: none" style="color:#FFF8DC">Add new department</a><br><br>
</form>
</font></center>
</body>
</html>