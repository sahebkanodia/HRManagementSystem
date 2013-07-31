<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Leave</title>
</head>
<body background="images/pattern.jpg">
<font color="#FFF8DC" style="Calibri">
<br><br><br><br><center><h1>Request a Leave</h1></center><br><br>
<center><pre><form method"="get" onSubmit="return validate()">
Enter the no. of leaves needed <br><br><br><br>
<input type="text" name="days" maxlength="2"></input><br><br><br><br>
<script>
function validate()
{
var x=document.getElementById("days").value;
if(x==""||isNaN(x))
	{alert("Enter Valid Number of Days!");}
else
	{window.location ="Leave";}
}
</script>

<input type="submit" name="Submit" value="Submit">


</form>

</pre>
</center></font>
</body>
</html>