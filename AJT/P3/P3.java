import java.sql.*;
import java.util.*;
import jdbc.*;

class P3
{
	public static void main(String[] args)
	{
		CallableStatement cstmt = null;
		Scanner sc = new Scanner(System.in);
		
		if(MySQL.connectCallableStatement("bank", "root", "mysql", "{call get_details(?,?,?)}"))
			cstmt = MySQL.getCallableStatement();
		else
			return;
		
		try
		{
			System.out.print("Enter Account No: ");
			cstmt.setInt(1, sc.nextInt());
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.DOUBLE);
			cstmt.execute();
		
			System.out.println("Account Holder's Name: " + cstmt.getString(2));
			System.out.println("Account Balance: " + cstmt.getDouble(3));
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
}