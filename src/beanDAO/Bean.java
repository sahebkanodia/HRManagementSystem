package beanDAO;

public class Bean {
	int id,cl,pl,lstatus,days,deptid;
	long mobno;
	String password,addr,email,name,dept,status,sex;
	
public int getid()
{
	return id;
}
public void setid(int id)
{
	this.id=id;
}
public int getdays()
{
	return days;
}
public void setdays(int days)
{
	this.days=days;
}
public int getdeptid()
{
	return deptid;
}
public void setdeptid(int deptid)
{
	this.deptid=deptid;
}

public String getpassword()
{
	return password;
}
public void setpassword(String password)
{
	this.password=password;
}

public long getmobno()
{
	return mobno;
}
public void setmobno(long mobno)
{
	this.mobno=mobno;
}

public int getcl()
{
	return cl;
}
public void setcl(int cl)
{
	this.cl=cl;
}

public int getpl()
{
	return pl;
}
public void setpl(int pl)
{
	this.pl=pl;
}

public int getlstatus()
{
	return lstatus;
}
public void setlstatus(int lstatus)
{
	this.lstatus=lstatus;
}

public String getname()
{
	return name;
}
public void setname(String name)
{
	this.name=name;
}

public String getaddr()
{
	return addr;
}
public void setaddr(String addr)
{
	this.addr=addr;
}

public String getemail()
{
	return email;
}
public void setemail(String email)
{
	this.email=email;
}

public String getstatus()
{
	return status;
}
public void setstatus(String status)
{
	this.status=status;
}

public String getdept()
{
	return dept;
}
public void setdept(String dept)
{
	this.dept=dept;
}

public String getsex()
{
	return sex;
}
public void setsex(String sex)
{
	this.sex=sex;
}

}

