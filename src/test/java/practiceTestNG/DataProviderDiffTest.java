package practiceTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DataProviderDiffTest {

	@Ignore
	public void getData(String from, String to) {
		System.out.println(from+"   "+to);
	}
	
	@Test (dataProviderClass = DataProviderTest.class, dataProvider = "data1")
	public void dragData(String UN, String PWD) {
		System.out.println(UN+"  "+PWD);
	}
	
	@Test
	public void fedtchData() {
		System.out.println("djcakfd");
	}
	@Test(priority = 0)
	public void ayyoData() {
		System.out.println("something");
	}
	@Test(invocationCount = 5)
	public void something() {
		System.out.println("invo");
	}
	
	
}
