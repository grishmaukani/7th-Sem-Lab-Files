import java.sql.*;
import java.util.*;
import jdbc.*;

class P2
{
	public static void main(String[] args)
	{
		CallableStatement cstmt = null;
		Scanner sc = new Scanner(System.in);
		
		if(MySQL.connectCallableStatement("bank", "root", "mysql", "{call add_data(?,?,?,?,?,?)}"))
			cstmt = MySQL.getCallableStatement();
		else
			return;
		
		try
		{
			System.out.print("Account No: ");
			cstmt.setInt(1, sc.nextInt());
			
			System.out.print("Account Type: ");
			cstmt.setString(2, sc.next());
			
			System.out.print("Account Holder's Name: ");
			cstmt.setString(3, sc.next());
			
			System.out.print("Account Balance: ");
			cstmt.setDouble(4, sc.nextDouble());
			
			sc.nextLine();
			System.out.print("Holder's Address: ");
			cstmt.setString(5, sc.nextLine());
			
			System.out.print("Holder's Contact No: ");
			cstmt.setLong(6, sc.nextLong());
			
			cstmt.execute();
			System.out.println("\n--> Record Inserted <--");
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
}