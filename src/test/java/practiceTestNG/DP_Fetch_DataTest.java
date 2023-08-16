package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.ExcelUtility;

public class DP_Fetch_DataTest {
	
	@Test( dataProvider = "fetchDataFromExcelUtilGeneric")
	public void fetchDataFromGenericExcel(String name, String emailId) {
		System.out.println(name+"     "+emailId);
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		DataProvider_Generic dpg= new DataProvider_Generic();
		Object[][] value=dpg.getMultipleDataFromExcel("Data_Provider");
		return value;
	}
	@DataProvider
	public Object[][] fetchDataFromExcelUtilGeneric() throws Throwable{
		ExcelUtility eLib= new ExcelUtility();
		Object[][] value= eLib.getMultipleDataFromExcelByDP("Data_Provider");
	return value;
	}
}
