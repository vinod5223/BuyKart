package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.BuyKart.GenericUtility.DataBaseUtility;
import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/buykart", "root", "root");
		Statement state = con.createStatement();	
		String query = "select * from buyKartUserInfo;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		String expUsername="Vinod";
//		result.next();
//			System.out.println(result.getString("s_no")	+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));	
			while(result.next()) {
				String act_username=result.getString(2);
				if(expUsername.equalsIgnoreCase(act_username)) {
					flag=true;
					break;
				}				
			}

			if(flag) {
				System.out.println("Data matched");
			}
			else {
				System.out.println("data not matched");
			}
/*
 * we can also write like this to fetch the value in a particular coloumn
 * we can give the column name in result.getString(*) (in place of *) instead of column number
 * example::
 *	result.next();
			System.out.println(result.getString("S_no")	+" "+result.getString("Username")+" "+result.getString("password")+" "+result.getString("status"));	
	
 * 
 * 
 * 
 * 
 */			
			con.close();
			
	}

}


/*
 * Actual String ="Electronics";
 * boolean flag=false;
 * while(result.next()){
 * String expected=result.getString(1);
 * System.out.println("expected String"+ expected);
 * if(actual.equals(expected))
 * {
 * System.out.println("data matched");
 * flag=true;
 * break;
 * }
 * if(flag){
 * } 
 * } 
 * */

//Create an object of driver, register the driver, get connection, create statement, execute statement, close the connection


