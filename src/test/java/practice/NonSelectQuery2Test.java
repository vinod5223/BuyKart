package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery2Test {

	public static void main(String[] args) throws Throwable {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "root");
		Statement st=conn.createStatement();
		String query="insert into buykartuserinfo values(3,'Athar', 'Test@123', 'active'),(4,'Ashish','Test@123','active');";
		int result=st.executeUpdate(query);
		
		if(result>0) {
			System.out.println("data inserted succesfully");
		}
		else {
			System.out.println("data not inserted");
		}
		
	}

}
