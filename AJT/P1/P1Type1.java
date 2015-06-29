import java.sql.*;

public class P1Type1
{
	public static void main(String[] args)
   	{
        		Connection con = null;
        
        		String url = "jdbc:odbc:adjava";
        		String username = "";
        		String password = "";
        
        		Statement stmt = null;
        		ResultSet rs = null;
		String sql;
		int r;       

        		try
        		{
            			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Found");
        		}
        		catch(ClassNotFoundException cnfe)
        		{
            			System.out.println(cnfe.getMessage());
        		}
        
        		try
        		{
             			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
			stmt = con.createStatement();
			System.out.println("Statement Created");
        		}
        		catch(SQLException sqle)
        		{
            			System.out.println(sqle.getMessage());
        		}

		sql = "insert into student values(1, 'abc')";
		try
		{
			r = stmt.executeUpdate(sql);
			System.out.println("Query Executed : " + r);		
		}
		catch(SQLException sqle)
		{
            			System.out.println(sqle.getMessage());
        		}
    	}
}