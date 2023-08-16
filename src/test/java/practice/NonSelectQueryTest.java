package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args)   {
		
		
		int result=0;
		Connection con=null;
		
		try
		{
			Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		 con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/buyKart", "root", "root");
		
		Statement state=con.createStatement();
		String query= "delete from buykartuserinfo where s_no=3 or s_no=4";
		 result = state.executeUpdate(query);
		System.out.println(result);
		}
		catch (Exception e) {
		}
		finally {
			if(result>0) {
				System.out.println("data inserted successfully");
			}
			else {
				System.err.println("data not inserted ");
			}
			
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
