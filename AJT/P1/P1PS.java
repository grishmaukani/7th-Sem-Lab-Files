import java.util.*;
import java.sql.*;
import jdbc.*;

public class P1PS
{
	static PreparedStatement psins = null, psdel = null, psupd = null;
	static Statement ssel = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{		
		String sql;
		int choice;
		
		if(MySQL.connectPreparedStatement("student", "root", "mysql", "insert into registration values(?, ?, ?, ?, ?, ?)"))
			psins = MySQL.getPreparedStatement();
		else
			return;
		
		if(MySQL.connectPreparedStatement("student", "root", "mysql", "delete from registration where id=?"))
			psdel = MySQL.getPreparedStatement();
		else
			return;
		
		if(MySQL.connectPreparedStatement("student", "root", "mysql", "update registration set age=? where id=?"))
			psupd = MySQL.getPreparedStatement();
		else
			return;
		
		if(MySQL.connect("student", "root", "mysql"))
			ssel = MySQL.getStatement();
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
		System.out.println("\nInsert Record:-");
		
		try
		{
			System.out.print("ID: ");
			psins.setInt(1, sc.nextInt());
			
			System.out.print("First Name: ");
			psins.setString(2, sc.next());
			
			System.out.print("Last Name: ");
			psins.setString(3, sc.next());
			
			sc.nextLine();
			System.out.print("Address: ");
			psins.setString(4, sc.nextLine());
			
			System.out.print("Contact No.: ");
			psins.setLong(5, sc.nextLong());
			
			System.out.print("Age: ");
			psins.setInt(6, sc.nextInt());
		
			psins.executeUpdate();
			System.out.println("--> Record Inserted <--");
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
	
	static void select()
	{
		String sql;
		ResultSet rs = null;
		
		System.out.println("\nRecords:-");
		
		sql = "select * from registration";
		try
		{
			rs = ssel.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("ID: " + rs.getInt("id") + "\nFirst Name: " + rs.getString("fname") + "\nLast Name: " + rs.getString("lname") + "\nAddress: " + rs.getString("address") + "\nContact No: " + rs.getLong("contact_no") + "\nAge: " + rs.getInt("age") + "\n");
			}
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		} 
	}
	
	
	static void delete()
	{
		select();
		
		try
		{
			System.out.print("Enter ID to Delete Record: ");
			psdel.setInt(1, sc.nextInt());
			
			psdel.executeUpdate();
			System.out.println("--> Record Deleted <--");
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
	
	static void update()
	{
		int id, age;
		String sql;
		
		select();
		try
		{
			System.out.print("Enter ID to Update Record: ");
			psupd.setInt(2, sc.nextInt());
			System.out.print("Enter new Age: ");
			psupd.setInt(1, sc.nextInt());
			
			psupd.executeUpdate();
			System.out.println("--> Record Updated <--");
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
}