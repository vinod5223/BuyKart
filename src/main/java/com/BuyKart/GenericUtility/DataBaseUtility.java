package com.BuyKart.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;
/**
 * This class consists of all the actions which can be done on database
 * @author USER
 *
 */
public class DataBaseUtility {
	Connection con=null;
	/**
	 * This method is used to establish the connection with the database
	 * @author Vinod
	 * @param query
	 * @throws Throwable
	 */
	public void connecToDB() throws Throwable {
		Driver driver= new Driver();
		
		DriverManager.registerDriver(driver);
		 con =	DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUserName, IPathConstants.dbPassWord);
	}
	/**
	 * This method is used to execute the query and get the data from query
	 * @param query
	 * @param columnNo
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnNo, String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		Boolean flag=false;
		while(result.next()) {
			String data =	result.getString(columnNo);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
			if(flag==true) {
				System.out.println("Data matched and verified");
				return expData;
			}
			else {
				return "";
			}	
		}
	/**
	 * This method is used to close the dataBase connection	
	 * @throws Exception
	 */
	public void closeDB() throws Exception {
		con.close();		
	}
	}

