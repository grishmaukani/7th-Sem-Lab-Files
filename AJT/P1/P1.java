import java.util.*;
import java.sql.*;
import jdbc.*;

public class P1
{
	static Statement stmt = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{		
		String sql;
		int choice;
		
		if(MySQL.connect("student", "root", "mysql"))
			stmt = MySQL.getStatement();
		else
			return;
		
		while(true)
		{
			System.out.print("\n1: INSERT\n2: UPDATE\n3: DELETE\n4: SELECT\n5: EXIT\nEnter Choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: insert();
						break;
						
				case 2: update();
						break;
						
				case 3: delete();
						break;
						
				case 4: select();
						break;
						
				case 5:	return;
						
				default: break;
			}
		}
	}
	
	static void insert()
	{
		String fname, lname, address, sql;
		int id, age;
		long contactNo;
		
		System.out.print("\nInsert Record:-");
		
		System.out.print("ID: ");
		id = sc.nextInt();
		
		System.out.print("First Name: ");
		fname = sc.next();
		
		System.out.print("Last Name: ");
		lname = sc.next();
		
		sc.nextLine();
		System.out.print("Address: ");
		address = sc.nextLine();
		
		System.out.print("Contact No.: ");
		contactNo = sc.nextLong();
		
		System.out.print("Age: ");
		age = sc.nextInt();
		
		sql = "insert into registration values(" + id + ", '" + fname + "', '" + lname + "', '" + address + "', " + contactNo + ", " + age + ")";
		try
		{
			stmt.executeUpdate(sql);
			System.out.println("--> Record Inserted <--");
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
	
	static void select()
	{
		RsultSet rs = null;
		
		String fname, lname, address, sql;
		int id, age;
		long contactNo;
		
		System.out.print("\nRecords:-");
		
		sql = "select * from registration";
		try
		{
			rs = stmt.executeQuery(sql);
			System.out.println("id\t|\tfname\t|\tlname\t|\taddress\t|\tcontact_no\t|\tage");
			
			System.out.println("--> Record Inserted <--");
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		} 
	}
}