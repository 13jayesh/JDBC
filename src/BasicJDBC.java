import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSet;

public class BasicJDBC {
	static Scanner sc=new Scanner(System.in);

public static void main(String args[]) throws SQLException, ClassNotFoundException
{ 
	
	System.out.println("Enter choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	
		case 1:
				insert();
		case 2:
				Remove();
		case 3:
			update();

	}	
}
public static void update()
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydata","root","root");
	PreparedStatement stmt=conn.prepareStatement("update Employee set name=? where id=?");  
	System.out.println("Enter name");
	String name=sc.next();
	System.out.println("Enter id");
	int id=sc.nextInt();
	
	stmt.setString(1,name);
	stmt.setInt(2,id);
	int i=stmt.executeUpdate();  
	System.out.println(i+" records updated");  
	
	conn.close();  
	}
	catch(Exception e)
	{ System.out.println(e);}  
	  
	}  

public static void Remove() throws SQLException, ClassNotFoundException 
{	
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydata","root","root");
	PreparedStatement stmt=conn.prepareStatement("delete from Employee where id=?");
	System.out.println("Enter id");
	int id=sc.nextInt();
	stmt.setInt(1,id);  
	int i=stmt.executeUpdate();  
	System.out.println(i+" records inserted");  
	

conn.close();  
}
catch(Exception e)
{ System.out.println(e);}  
  
}  


public static void insert() throws ClassNotFoundException, SQLException
{
	try{

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydata","root","root");
	
	PreparedStatement stmt= conn.prepareStatement("insert into Employee values(?,?,?,?)");  
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter id");
	int id=sc.nextInt();
	System.out.println("Enter name");
	String name=sc.next();
	System.out.println("Enter age");
	int age=sc.nextInt();
	System.out.println("Enter salary");
	int salary=sc.nextInt();
	
	stmt.setInt(1,id);
	stmt.setString(2, name);
	stmt.setInt(3,age);
	stmt.setInt(4,salary);
	
	int i=stmt.executeUpdate();  
	System.out.println(i+" records inserted");  
	

conn.close();  
  
	}
catch(Exception e)
{ System.out.println(e);}  
  
}  
}
