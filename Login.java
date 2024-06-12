package login;

import java.util.*;
import java.sql.*;

public class login {
			public static void main(String arg[])
			{
				Scanner sc=new Scanner(System.in);
				Connection con = null;
				String url="jdbc:mysql://localhost:3306/register";
				String un="root";
				String Password="2000";
				String Query="select *from signup where username=(?) and password=(?)" ;
				PreparedStatement pstmt=null;


				
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					con = DriverManager.getConnection(url,un,Password);
					pstmt=con.prepareStatement(Query);	
					System.out.println("Enter the username");
					String username=sc.next();
					pstmt.setString(1, username);
					
					System.out.println("Enter the password");
					String password=sc.next();
					pstmt.setString(2, password);

					ResultSet res=pstmt.executeQuery();
					
					if(res.next()) {
						System.out.println("username and password matched");
					}
					else {
						System.out.println("not matched");
					}
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
				
