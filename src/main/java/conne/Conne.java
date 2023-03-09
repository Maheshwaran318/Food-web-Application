package conne;
import java.sql.*;
public class Conne {
	public static  Connection con()
	{
		Connection conn = null;
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swizo","root","Mm@9629104571");
		}
		catch(Exception e)
		{
			
		}
		return conn;
	}
}
