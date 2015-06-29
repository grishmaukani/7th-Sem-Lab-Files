import java.sql.*;

public class P1Type4
{
    	public static void main(String[] args)
    	{
        	Connection con;
        
        	String url = "mysql:jdbc://localhost:3306/mydb";
        	String username = "root";
        	String password = "mysql";
        
        	Statement stmt;
        	ResultSet rs;
        
        	try
        	{
            		Class.forName("com.mysql.jdbc.Driver");
        	}
        	catch(ClassNotFoundException cnfe)
        	{
            		System.out.println(cnfe.getMessage());
        	}
        
        	try
        	{
             		con = DriverManager.getConnection(url, username, password);
	
        	}
        	catch(SQLException sqle)
        	{
            		System.out.println(sqle.getMessage());
        	}
		sql = "insert into student values(1, 'abc')";
		try
		{
			stmt.executeUpdate(sql);			
		}
		catch(SQLException sqle)
		{
        		System.out.println(sqle.getMessage());
        	}
	}
}
