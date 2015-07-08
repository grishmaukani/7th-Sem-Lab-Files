package jdbc;

import java.sql.*;

public class MySQL
{
	static Connection con = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static CallableStatement cstmt = null;
	
	public static void establishConnection(String dbName, String un, String pass) throws SQLException, ClassNotFoundException
	{
		String url = "jdbc:mysql://localhost:3306/" + dbName;
			
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("driver loaded");
		con = DriverManager.getConnection(url, un, pass);
		//System.out.println("connection established");
	}
	
	public static boolean connect(String dbName, String un, String pass)
	{			
		try
		{
			establishConnection(dbName, un, pass);
			stmt = con.createStatement();
			//System.out.println("wrapper created");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("driver not loaded : " + cnfe.getMessage());
			return false;
		}
		catch(SQLException sqle)
		{
			System.out.println("couldn't connect : " + sqle.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean connectSU(String dbName, String un, String pass)
	{
		try
		{
			establishConnection(dbName, un, pass);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//System.out.println("wrapper created");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("driver not loaded : " + cnfe.getMessage());
			return false;
		}
		catch(SQLException sqle)
		{
			System.out.println("couldn't connect : " + sqle.getMessage());
			return false;
		}
		return true;
	}
	
	public static Statement getStatement()
	{
		return stmt;
	}
	
	public static boolean connectPreparedStatement(String dbName, String un, String pass, String sql)
	{
		try
		{
			establishConnection(dbName, un, pass);
			pstmt = con.prepareStatement(sql);
			//System.out.println("wrapper created");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("driver not loaded : " + cnfe.getMessage());
			return false;
		}
		catch(SQLException sqle)
		{
			System.out.println("couldn't connect : " + sqle.getMessage());
			return false;
		}
		return true;
	}
	
	public static PreparedStatement getPreparedStatement()
	{
		return pstmt;
	}
	
	public static boolean connectCallableStatement(String dbName, String un, String pass, String sql)
	{
		try
		{
			establishConnection(dbName, un, pass);
			cstmt = con.prepareCall(sql);
			//System.out.println("wrapper created");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("driver not loaded : " + cnfe.getMessage());
			return false;
		}
		catch(SQLException sqle)
		{
			System.out.println("couldn't connect : " + sqle.getMessage());
			return false;
		}
		return true;
	}
	
	public static CallableStatement getCallableStatement()
	{
		return cstmt;
	}
}