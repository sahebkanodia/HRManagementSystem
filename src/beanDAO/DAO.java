package beanDAO;
import java.sql.*;

import connection.Conn;
import java.io.*;
public class DAO 
{
	Connection con=Conn.getConn();
	public int checkDetails(Bean b) throws SQLException
	{	
		int flag=0;
		int id;
		String pw;
		id=b.getid();
		pw=b.getpassword();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select id,password,status from employee");
		while(rs.next())
		{
			if(rs.getInt(1)==id && (rs.getString(2)).equals(pw) && rs.getString(3).equals("Employed"))
			{
				flag=1;
				b.setid(id);
				return flag;
			}
			
		}
		return flag;
	}
	public void approve(Bean b) throws SQLException
	{
		int id=b.getid(),cl=0,pl=0,days=0;
		PreparedStatement st=con.prepareStatement("Select * from employee where id=?");
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			pl=rs.getInt(9);
			cl=rs.getInt(10);
			days=rs.getInt(11);
		}
		if(days<=3)
			cl+=days;
		else
			pl+=days;
		PreparedStatement ps=con.prepareStatement("update employee set pl=?,cl=?,days=?,lstatus=? where id=?");
		ps.setInt(1, pl);
		ps.setInt(2,cl);
		ps.setInt(3, 0);
		ps.setInt(4, 0);
		ps.setInt(5, id);
		ps.executeUpdate();
		
	}
	public ResultSet tableE() throws SQLException
	{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from employee");
		return rs;
	}
	public ResultSet tableD() throws SQLException
	{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from department");
		return rs;
	}

	public void addDetails(Bean b)throws ClassNotFoundException,SQLException,IllegalAccessException,InstantiationException
	{
		
		String name, addr, email, sex,password,status;
		int id,cl,pl,days,lstatus,deptid;
		long mobno;
		name=b.getname();
		addr=b.getaddr();
		email=b.getemail();
		sex=b.getsex();
		mobno=b.getmobno();
		
		PreparedStatement insertEmp=con.prepareStatement("insert into employee(id,name,addr,email,sex,password,status,mobno,pl,cl,days,lstatus,deptid) values(empid.nextval,?,?,?,?,?,?,?,?,?,?,?,?)");
		insertEmp.setString(1,name);
		insertEmp.setString(2,addr);
		insertEmp.setString(3,email);
		insertEmp.setString(4,sex);
		password=name.substring(0,1).concat(String.valueOf(mobno));
		insertEmp.setString(5,password);
		insertEmp.setString(6,"Employed");
		insertEmp.setLong(7, mobno);
		insertEmp.setInt(8, 0);
		insertEmp.setInt(9, 0);
		insertEmp.setInt(10,0);
		insertEmp.setInt(11,0);
		insertEmp.setInt(12,0);
		insertEmp.executeUpdate();
	}
	public ResultSet dispDetails() throws SQLException
	{
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select max(id) from employee");
		int id=0;
		while (rs.next())
		id=rs.getInt(1);
		PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
		ps.setInt(1, id);
		rs=ps.executeQuery();
		return rs;
	}
	public void removeEmp(Bean b) throws SQLException
	{
		
		int id=b.getid();
		PreparedStatement ps=con.prepareStatement("update employee set status=? where id=?");
		ps.setString(1, "Ex-Employee");
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	public void addDemp(Bean b) throws SQLException
	{
		int id=b.getid();
		String dept=b.getdept();
		int deptid=0;
		PreparedStatement ps=con.prepareStatement("Select max(deptid) from department");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			deptid=rs.getInt(1);
		PreparedStatement ps1=con.prepareStatement("update employee set deptid=? where id=?");
		ps1.setInt(1, deptid);
		ps1.setInt(2, id);
		ps1.executeUpdate();
	}
	public int leaveCheck(Bean b) throws SQLException
	{
		
		int days=b.getdays();
		int id=b.getid(),cl=0,pl=0,flag=0;
		PreparedStatement ps=con.prepareStatement("Select cl,pl from employee where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			cl=rs.getInt(1);
			pl=rs.getInt(2);
		}
		
		if(days>3)
		{
			if((pl+days)<=30)
			{
				flag=1;
				ps=con.prepareStatement("update employee set days=?,lstatus=? where id=?");
				ps.setInt(1,days);
				ps.setInt(2, 1);
				ps.setInt(3, id);
				ps.executeUpdate();
			}
		}
		else
		{
			if((cl+days)<=12)
			{
				flag=1;
				ps=con.prepareStatement("update employee set days=?,lstatus=? where id=?");
				ps.setInt(1, days);
				ps.setInt(2, 1);
				ps.setInt(3, id);
				ps.executeUpdate();
			}
		}
		return flag;
	}
	public void EditDetails(Bean b,String mob) throws SQLException
	{
		long mobno=0;
		int id=b.getid();
		String name=b.getname();
		String addr=b.getaddr(),email=b.getemail(), sex=b.getsex(), password=b.getpassword();
		if(name.equalsIgnoreCase("")==false)
		{
			PreparedStatement ps=con.prepareStatement("update employee set name=? where id=?");
			ps.setString(1, name);
			ps.setInt(2,id);
			ps.executeUpdate();
		}
		if(mob.equals("")==false)
		{
			PreparedStatement ps=con.prepareStatement("update employee set mobno=? where id=?");
			ps=con.prepareStatement("update employee set mobno=? where id=?");
			mobno=Long.parseLong(mob);
			ps.setLong(1, mobno);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		if(addr.equalsIgnoreCase("")==false)
		{
			PreparedStatement ps=con.prepareStatement("update employee set addr=? where id=?");
			ps.setString(1, addr);
			ps.setInt(2,id);
			ps.executeUpdate();
		}
		if(email.equalsIgnoreCase("")==false)
		{
			PreparedStatement ps=con.prepareStatement("update employee set email=? where id=?");
			ps.setString(1, email);
			ps.setInt(2,id);
			ps.executeUpdate();
		}
		if(sex.equalsIgnoreCase("")==false)
		{
			PreparedStatement ps=con.prepareStatement("update employee set sex=? where id=?");
			ps.setString(1, sex);
			ps.setInt(2,id);
			ps.executeUpdate();
		}
		if(password.equalsIgnoreCase("")==false)
		{
			PreparedStatement ps=con.prepareStatement("update employee set password=? where id=?");
			ps.setString(1, password);
			ps.setInt(2,id);
			ps.executeUpdate();
		}
		
	}
	public void addDpt(Bean b) throws SQLException
	{
		String dept=b.getdept();
		PreparedStatement ps=con.prepareStatement("insert into department(deptid,dept) values(deptno.nextval,?)");
		ps.setString(1,dept);
		ps.executeUpdate();
	}
	public void setD(Bean b) throws SQLException
	{
		int id,deptid;
		id=b.getid();
		deptid=b.getdeptid();
		PreparedStatement ps=con.prepareStatement("update employee set deptid=? where id=?");
		ps.setInt(1, deptid);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
}
