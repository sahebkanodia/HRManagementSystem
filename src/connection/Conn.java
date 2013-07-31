package connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conn {

public static Connection getConn()
{
	 Connection con=null;
		try
		{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
				con = DriverManager.getConnection(url, "system", "root"); 
				System.out.println("Connection established successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
