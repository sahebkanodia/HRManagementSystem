<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Employee</title>
</head>
<body background="images/pattern.jpg" text-align="center">
<div align="center">
<form method="get" action="AddEmp"><!-- Submit the details here-->
<font color="FFF8DC";size="5px";>
DETAILS OF NEW EMPLOYEE<br><br><br>
Name :			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type ="text" name="name"></input><br><br>
Mobile No. :	<input type ="text" name="mobno"></input><br><br>
Address :		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type ="text" name="addr"></input><br><br>
Email ID :		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type ="text" name="email"></input><br><br>
Sex : 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;M<input type ="radio" name="sex" value="M"></input>&nbsp;&nbsp;&nbsp;&nbsp;F<input type ="radio" name="sex" value="F"></input><br><br>
<input type="submit" name="Submit" value="Submit"></input><br>
<script>
function myFunction()
{
var x=document.getElementById("num").value;
if(x==""||isNaN(x))
	{alert("Please Enter Valid Mobile Number!");}
else
	{window.location ="addDept.jsp";}
}
</script>

</form>
</div>
</body>
</html>