import java.sql.*;
import java.io.*;
public class DConnection
{
	
	static Connection con;
	public static Connection getConnection()
	{
		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:plc");
		
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con)
	{
		try{
		con.close();
		}catch(Exception e){e.printStackTrace();}
	}
}