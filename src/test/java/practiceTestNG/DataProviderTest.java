package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	
	
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[2][2];
		obj[0][0]= "Singapore";
		obj[0][1]= "Bangalore";
		
		obj[1][0]="Pune";
		obj[1][1]="Mumbai";
		return obj;
	}
	
	
	@DataProvider
	public Object[][] data1(){
		Object[][] obj= new Object[2][2];
		obj[0][0]="anuj.lpu1@gmail.com";
		
		
		obj[1][0]="admin";
		obj[1][1]="Test@123";	
		return obj;
	
	}
	
	@DataProvider
	public Object[] data2() {
		Object[] obj= new Object[2];
		obj[0]="newString";
		obj[1]="oldString";
		return obj;
	}
	
	
	@Test(dataProvider = "data")
	public void fetchData(String frm, String to) {
		System.out.println(frm+"  "+to);
	}
}



























