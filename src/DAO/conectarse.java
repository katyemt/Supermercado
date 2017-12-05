package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conectarse 
{ Connection cc=null;
	public Connection conexion() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		cc=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
		return cc;
	}

}
