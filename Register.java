package login;

import java.sql.*;
import java.util.Scanner;

public class Register {
		public static void main(String arg[])
		{
			Scanner sc=new Scanner(System.in);
			Connection con = null;
			String url="jdbc:mysql://localhost:3306/register";
			String un="root";
			String Password="2000";
			String Query="insert into signup values (?,?,?,?);" ;
			PreparedStatement pstmt=null;


			
			try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				con = DriverManager.getConnection(url,un,Password);
				pstmt=con.prepareStatement(Query);	
				System.out.println("Enter the username");
				String username=sc.next();
				pstmt.setString(1, username);
				
				System.out.println("Enter the name");
				String name=sc.next();
				pstmt.setString(2, name);
				
				System.out.println("Enter the age");
				int age=sc.nextInt();
				pstmt.setInt(3, age);
				
				System.out.println("Enter the password");
				String password=sc.next();
				pstmt.setString(4, password);
				
				pstmt.executeUpdate();
				
				
		
				
			
		}
			catch (Exception exception) {
				System.out.println(exception);
			}
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	}

