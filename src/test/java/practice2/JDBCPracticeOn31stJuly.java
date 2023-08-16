package practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCPracticeOn31stJuly {

	public static void main(String[] args) throws SQLException {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "root");
		Statement st=conn.createStatement();
		
		ResultSet result= st.executeQuery("Select* from buykartuserinfo;");
		boolean flag=false;
		while(result.next()) {
			String name=result.getString("username");
			if(name.equalsIgnoreCase("Vinod")) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("data matched");
		}
		else {
			System.out.println("data not matched");
		}

		conn.close();
	}

}
